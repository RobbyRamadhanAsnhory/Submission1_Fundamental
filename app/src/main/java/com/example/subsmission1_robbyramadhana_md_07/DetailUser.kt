package com.example.subsmission1_robbyramadhana_md_07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.subsmission1_robbyramadhana_md_07.databinding.ActivityDetailUserBinding

class DetailUser : AppCompatActivity() {

    companion object {
        const val EXTRA_USER = "EXTRA_USER"
    }

    private lateinit var bindingDetail: ActivityDetailUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingDetail = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(bindingDetail.root)

        val user = intent.getParcelableExtra<DataUser>(EXTRA_USER)

        bindingDetail.apply {
            detailUsername.text = user?.username
            detailName.text = user?.name
            detailLocation.text = user?.location
            detailRepository.text = user?.repository
            detailCompany.text = user?.company
            detailFollowers.text = user?.followers
            detailFollowing.text = user?.following
        }

        Glide.with(this)
            .load(user?.avatar)
            .apply(RequestOptions.circleCropTransform())
            .into(bindingDetail.detailAvatar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = user?.username
            elevation = 0f
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}