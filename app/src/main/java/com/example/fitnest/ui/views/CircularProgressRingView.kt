package com.example.fitnest.ui.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.example.fitnest.R

class CircularProgressRingView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var progress: Float = 75f
    private val strokeWidthDp = 10f

    private val trackPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeCap = Paint.Cap.ROUND
        color = ContextCompat.getColor(context, R.color.primary_light)
    }

    private val progressPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeCap = Paint.Cap.ROUND
        color = ContextCompat.getColor(context, R.color.primary_bright)
    }

    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textAlign = Paint.Align.CENTER
        color = ContextCompat.getColor(context, R.color.text_main)
        isFakeBoldText = true
    }

    private val rectF = RectF()

    fun setProgress(value: Float) {
        progress = value.coerceIn(0f, 100f)
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val density = resources.displayMetrics.density
        val stroke = strokeWidthDp * density
        trackPaint.strokeWidth = stroke
        progressPaint.strokeWidth = stroke

        val padding = stroke / 2f + 4f * density
        val size = Math.min(width, height).toFloat()
        rectF.set(
            (width - size) / 2f + padding,
            (height - size) / 2f + padding,
            (width + size) / 2f - padding,
            (height + size) / 2f - padding
        )

        // Draw track circle
        canvas.drawArc(rectF, 0f, 360f, false, trackPaint)

        // Draw progress arc (start from top: -90 deg)
        val sweepAngle = (progress / 100f) * 360f
        canvas.drawArc(rectF, -90f, sweepAngle, false, progressPaint)

        // Draw center percentage text
        textPaint.textSize = size * 0.22f
        val text = "${progress.toInt()}%"
        val textY = (height / 2f) - ((textPaint.descent() + textPaint.ascent()) / 2f)
        canvas.drawText(text, width / 2f, textY, textPaint)
    }
}
