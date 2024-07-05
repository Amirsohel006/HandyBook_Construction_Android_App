package com.example.handybook_construction_android_app.ui.trackorderactivity

import android.graphics.drawable.Drawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.handybook_construction_android_app.R

class TrackOrderActivity : AppCompatActivity() {

    private lateinit var firstDot: View
    private lateinit var secondDot: View
    private lateinit var thirdDot: View
    private lateinit var forthDot: View

    private lateinit var pgFirst: View
    private lateinit var pgSecond: View
    private lateinit var pgThird: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_track_order)
        val backView = findViewById<ImageView>(R.id.ivTrackOrderBack)
        backView.setOnClickListener {
            finish()
        }
        firstDot = findViewById(R.id.vProgressFirst)
        secondDot = findViewById(R.id.vProgressSecond)
        thirdDot = findViewById(R.id.vProgressThird)
        forthDot = findViewById(R.id.vProgressFourth)

        pgFirst = findViewById(R.id.pgProgressFirst)
        pgSecond = findViewById(R.id.pgProgressSecond)
        pgThird = findViewById(R.id.pgProgressThird)

        setupProgressBar()
    }

    private fun setupProgressBar() {
        val dotColor = ContextCompat.getColor(this, R.color.green)
        val progressColor = ContextCompat.getColor(this, R.color.green)

        // Set dot colors
        findViewById<View>(R.id.vProgressFirst).background = getCircleDrawable(dotColor)
        findViewById<View>(R.id.vProgressSecond).background = getCircleDrawable(dotColor)
        findViewById<View>(R.id.vProgressThird).background = getCircleDrawable(dotColor)
//        findViewById<View>(R.id.vProgressFourth).background = getCircleDrawable(dotColor)

        // Set progress bars to green
        setProgressColor(findViewById(R.id.pgProgressFirst), progressColor, 0.5f)
        setProgressColor(findViewById(R.id.pgProgressSecond), progressColor, 0.5f)
//        setProgressColor(findViewById(R.id.pgProgressThird), progressColor, 0.5f)
    }

    private fun getCircleDrawable(color: Int): Drawable {
        val shapeDrawable = ShapeDrawable()
        shapeDrawable.shape = OvalShape()
        shapeDrawable.paint.color = color
        return shapeDrawable
    }

    private fun setProgressColor(progressView: View, color: Int, progress: Float) {
        val layoutParams = progressView.layoutParams as ViewGroup.LayoutParams
        layoutParams.height = (layoutParams.height * progress).toInt()
        progressView.layoutParams = layoutParams
        progressView.setBackgroundColor(color)
    }
}