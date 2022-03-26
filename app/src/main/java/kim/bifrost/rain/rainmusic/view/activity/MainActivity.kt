package kim.bifrost.rain.rainmusic.view.activity

import android.graphics.Color
import android.os.Bundle
import android.view.animation.AlphaAnimation
import androidx.core.view.postDelayed
import kim.bifrost.rain.rainmusic.R
import kim.bifrost.rain.rainmusic.base.ui.BaseBindActivity
import kim.bifrost.rain.rainmusic.databinding.ActivityMainBinding
import kim.bifrost.rain.rainmusic.utils.extensions.gone
import kim.bifrost.rain.rainmusic.utils.extensions.setOnEnd
import kim.bifrost.rain.rainmusic.view.fragment.SplashFragment

class MainActivity : BaseBindActivity<ActivityMainBinding>(isCancelStatusBar = true) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        replaceFragment(R.id.splash_screen) {
            SplashFragment()
        }

        // 使用 Handler 更轻量级一些
        binding.splashScreen.postDelayed(1600) {
            // 来个淡出动画，它不香吗？:)
            binding.splashScreen.startAnimation(
                AlphaAnimation(1F, 0F).apply {
                    duration = 400
                    setOnEnd {
                        binding.splashScreen.gone() // 这里使用 GONE 要好一些，因为 INVISIBLE 是会拦截点击事件的
                    }
                }
            )
        }
        // DrawerLayout 的状态栏颜色
        binding.dl.setStatusBarBackgroundColor(Color.TRANSPARENT)
    }
}