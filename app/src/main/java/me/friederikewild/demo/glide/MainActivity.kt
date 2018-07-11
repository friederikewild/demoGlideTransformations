package me.friederikewild.demo.glide

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import kotlinx.android.synthetic.main.activity_main.*
import me.friederikewild.demo.glide.util.GlideApp

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // For testing: Url to test profile picture
        val pictureUrl = "https://upload.wikimedia.org/wikipedia/commons/d/dd/Chuck_Norris_Small.JPG"
        val radius = resources.getDimensionPixelSize(R.dimen.profile_corner_radius)

        GlideApp.with(this)
                .load(pictureUrl)
                .transform(RoundedCorners(radius))
// .transforms(CenterCrop(), RoundedCorners(radius))
                .placeholder(R.drawable.placeholder_thumbnail_square_primary)
                .error(R.drawable.placeholder_thumbnail_square_primary)
                .transition(DrawableTransitionOptions.withCrossFade()).into(detailProfilePicture)
    }
}
