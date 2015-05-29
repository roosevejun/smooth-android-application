package com.smooth.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.google.zxing.ResultPoint;
import com.smooth.R;
import com.smooth.ercode.CameraManager;
import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.res.ColorRes;
import org.androidannotations.annotations.res.DrawableRes;

import java.util.Collection;
import java.util.HashSet;

/**
 * 项目名称：smooth-android-application
 * 包名称：com.smooth.view
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2015/5/29-15:50
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
@EViewGroup
public final class ErcodeScanView extends View {
    static final int[] SCANNER_ALPHA = {0, 64, 128, 192, 255, 192, 128, 64};
    static final long ANIMATION_DELAY = 100L;
    static final int OPAQUE = 0xFF;
    static final int SPEEN_DISTANCE = 5;
    static final int MIDDLE_LINE_PADDING = 5;
    static final int MIDDLE_LINE_WIDTH = 5;

    final Paint paint;

    Bitmap resultBitmap;
    @ColorRes(R.color.viewfinder_mask)
    int maskColor;
    @ColorRes(R.color.result_view)
     int resultColor;
    @ColorRes(R.color.viewfinder_frame)
     int frameColor;
    @ColorRes(R.color.possible_result_points)
     int resultPointColor;
    Collection<ResultPoint> possibleResultPoints;
    Collection<ResultPoint> lastPossibleResultPoints;
    boolean isFirst;
    int slideTop;
    int slideBottom;
    @DrawableRes(R.drawable.qrcode_scan_line)
    Bitmap qrLineBitmap;// 扫描的分割线
    int qrWidth;// 扫描线的长
    int qrHeight;// 扫描线的高
    Rect qrSrc;
    Rect qrDst;


    public ErcodeScanView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
    }

    @AfterInject
    void afterInject() {

    }

    @Override
    public void onDraw(Canvas canvas) {
        Rect frame = CameraManager.get().getFramingRect();
        if (frame == null) {
            return;
        }

        // 初始化中间线滑动的最上边和最下边
        if (!isFirst) {
            isFirst = true;
            slideTop = frame.top;
            slideBottom = frame.bottom;
        }

        int width = canvas.getWidth();
        int height = canvas.getHeight();

        // Draw the exterior (i.e. outside the framing rect) darkened
        paint.setColor(resultBitmap != null ? resultColor : maskColor);
        canvas.drawRect(0, 0, width, frame.top, paint);
        canvas.drawRect(0, frame.top, frame.left, frame.bottom + 1, paint);
        canvas.drawRect(frame.right + 1, frame.top, width, frame.bottom + 1, paint);
        canvas.drawRect(0, frame.bottom + 1, width, height, paint);

        if (resultBitmap != null) {
            // Draw the opaque result bitmap over the scanning rectangle
            paint.setAlpha(OPAQUE);
            canvas.drawBitmap(resultBitmap, frame.left, frame.top, paint);
        } else {

            // 绘制中间的线,每次刷新界面，中间的线往下移动SPEEN_DISTANCE
            slideTop += SPEEN_DISTANCE;
            if (slideTop >= frame.bottom) {
                slideTop = frame.top;
            }

            qrDst = new Rect(frame.left, slideTop, frame.right, slideTop + qrHeight);
            canvas.drawBitmap(qrLineBitmap, qrSrc, qrDst, null);

            int linewidth = 10;
            paint.setColor(frameColor);

            // draw rect
            canvas.drawRect(15 + frame.left, 15 + frame.top, 15 + (linewidth + frame.left), 15 + (50 + frame.top), paint);
            canvas.drawRect(15 + frame.left, 15 + frame.top, 15 + (50 + frame.left), 15 + (linewidth + frame.top), paint);
            canvas.drawRect(-15 + ((0 - linewidth) + frame.right), 15 + frame.top, -15 + (1 + frame.right), 15 + (50 + frame.top), paint);
            canvas.drawRect(-15 + (-50 + frame.right), 15 + frame.top, -15 + frame.right, 15 + (linewidth + frame.top), paint);
            canvas.drawRect(15 + frame.left, -15 + (-49 + frame.bottom), 15 + (linewidth + frame.left), -15 + (1 + frame.bottom), paint);
            canvas.drawRect(15 + frame.left, -15 + ((0 - linewidth) + frame.bottom), 15 + (50 + frame.left), -15 + (1 + frame.bottom), paint);
            canvas.drawRect(-15 + ((0 - linewidth) + frame.right), -15 + (-49 + frame.bottom), -15 + (1 + frame.right), -15 + (1 + frame.bottom), paint);
            canvas.drawRect(-15 + (-50 + frame.right), -15 + ((0 - linewidth) + frame.bottom), -15 + frame.right, -15 + (linewidth - (linewidth - 1) + frame.bottom), paint);

            Collection<ResultPoint> currentPossible = possibleResultPoints;
            Collection<ResultPoint> currentLast = lastPossibleResultPoints;
            if (currentPossible.isEmpty()) {
                lastPossibleResultPoints = null;
            } else {
                possibleResultPoints = new HashSet<ResultPoint>(5);
                lastPossibleResultPoints = currentPossible;
                paint.setAlpha(OPAQUE);
                paint.setColor(resultPointColor);
                for (ResultPoint point : currentPossible) {
                    canvas.drawCircle(frame.left + point.getX(), frame.top + point.getY(), 6.0f, paint);
                }
            }
            if (currentLast != null) {
                paint.setAlpha(OPAQUE / 2);
                paint.setColor(resultPointColor);
                for (ResultPoint point : currentLast) {
                    canvas.drawCircle(frame.left + point.getX(), frame.top + point.getY(), 3.0f, paint);
                }
            }

            // Request another update at the animation interval, but only
            // repaint the laser line,
            // not the entire viewfinder mask.
            postInvalidateDelayed(ANIMATION_DELAY, frame.left, frame.top, frame.right, frame.bottom);
        }
    }

    public void drawViewfinder() {
        resultBitmap = null;
        invalidate();
    }

    /**
     * Draw a bitmap with the result points highlighted instead of the live
     * scanning display.
     *
     * @param barcode
     *            An image of the decoded barcode.
     */
    public void drawResultBitmap(Bitmap barcode) {
        resultBitmap = barcode;
        invalidate();
    }

    public void addPossibleResultPoint(ResultPoint point) {
        possibleResultPoints.add(point);
    }

}
