package com.example.subsmission1_robbyramadhana_md_07

import android.content.Context
import android.content.res.TypedArray

object IsiData {

    private lateinit var dataAvatar: TypedArray
    private lateinit var dataUsername: Array<String>
    private lateinit var dataName: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataFollowers : Array<String>
    private lateinit var dataFollowing: Array<String>


    private fun prepareData(context: Context) {
        dataAvatar = context.resources.obtainTypedArray(R.array.avatar)
        dataUsername = context.resources.getStringArray(R.array.username)
        dataName = context.resources.getStringArray(R.array.name)
        dataLocation = context.resources.getStringArray(R.array.location)
        dataRepository = context.resources.getStringArray(R.array.repository)
        dataCompany = context.resources.getStringArray(R.array.company)
        dataFollowers = context.resources.getStringArray(R.array.followers)
        dataFollowing = context.resources.getStringArray(R.array.following)
    }

    fun listUser(context: Context): ArrayList<DataUser> {
        val listOfUser = ArrayList<DataUser>()
        prepareData(context)

        for (position in dataUsername.indices) {
            val user = DataUser(
                avatar = dataAvatar.getResourceId(position, 0),
                username = dataUsername[position],
                name = dataName[position],
                location = dataLocation[position],
                repository = dataRepository[position],
                company = dataCompany[position],
                followers = dataFollowers[position],
                following = dataFollowing[position],

            )

            listOfUser.add(user)
        }

        return listOfUser
    }
}