package com.gc.demoapp

import android.os.Bundle
import com.gc.navigationinjector.BaseActivity
import android.support.design.widget.NavigationView
import android.view.MenuItem
import android.view.View
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.Gravity


class PrivateActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun getFragmentContainer(): Int = R.id.fragmentContainer

    override fun onCreate(savedInstanceState : Bundle?) {
        setContentView(R.layout.activity_private)
        super.onCreate(savedInstanceState)
        configurateNavigationDrawer()
    }

    private fun configurateNavigationDrawer(){
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.setDrawerListener(toggle)
        toggle.syncState()


        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val nextState = when(item.itemId){
            R.id.itemGlobalPosition -> MyStates.PRODUCT_LIST
            R.id.itemInfo -> MyStates.INFO
            else -> MyStates.LOGIN
        }
        findViewById<DrawerLayout>(R.id.drawer_layout).closeDrawer(Gravity.START)
        if(currentState != nextState) navigateTo(nextState)
        return true
    }

}
