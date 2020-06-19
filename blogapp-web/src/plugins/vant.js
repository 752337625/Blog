import Vue from 'vue'
import {
	Button,
	Tabbar,
	TabbarItem,
	Image as VanImage,
	Lazyload,
	NavBar,
	Icon,
	Field
} from 'vant';
// 注册时设置`lazyComponent`选项
Vue.use( Lazyload, {
	lazyComponent: true,
} );
Vue.use( Button )
Vue.use( Tabbar );
Vue.use( TabbarItem );
Vue.use( VanImage );
Vue.use( Lazyload );
Vue.use( NavBar );
Vue.use( Icon );
Vue.use( Field )
