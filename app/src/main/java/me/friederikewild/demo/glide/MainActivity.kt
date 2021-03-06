package me.friederikewild.demo.glide

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import kotlinx.android.synthetic.main.activity_main.*
import me.friederikewild.demo.glide.util.GlideApp

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // For testing: Url to test profile picture
        val pictureUrl = "https://upload.wikimedia.org/wikipedia/commons/9/93/ChuckNorris200611292256.jpg"
        val radius = resources.getDimensionPixelSize(R.dimen.profile_corner_radius)

        GlideApp.with(this)
                .load("INVALID_URL")
                .transform(RoundedCorners(radius))
// .transforms(CenterCrop(), RoundedCorners(radius))
                .placeholder(R.drawable.placeholder_thumbnail_square_dec_primary)
                .error(R.drawable.placeholder_thumbnail_square_dec_primary)
                .transition(DrawableTransitionOptions.withCrossFade()).into(previewProfilePicture)

        GlideApp.with(this)
                .load(pictureUrl)
                .transforms(CenterCrop(), RoundedCorners(radius))
                .placeholder(R.drawable.placeholder_thumbnail_square_dec_primary)
                .error(R.drawable.placeholder_thumbnail_square_dec_primary)
                .transition(DrawableTransitionOptions.withCrossFade()).into(detailProfilePicture)
    }
}
