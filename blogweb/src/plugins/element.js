import Vue from 'vue'

import {
    Row,
    Col,
    Input,
    Form,
    FormItem,
    Button,
    Message,
    Container,
    Header,
    Aside,
    Main,
    Footer,
    Menu,
    Submenu,
    MenuItem,
    MenuItemGroup,
    Popover,
    Card,
    Breadcrumb,
    BreadcrumbItem,
} from 'element-ui';
//Layout 布局隐藏
import 'element-ui/lib/theme-chalk/display.css';
Vue.use(Button)
Vue.use(Row)
Vue.use(Col)
Vue.use(Input)
Vue.use(Form)
Vue.use(FormItem)
Vue.use(Container)
Vue.use(Header)
Vue.use(Aside)
Vue.use(Main)
Vue.use(Footer)
Vue.use(Menu)
Vue.use(Submenu)
Vue.use(MenuItem)
Vue.use(MenuItemGroup)
Vue.use(Popover)
Vue.use(Card)
Vue.use(Breadcrumb)
Vue.use(BreadcrumbItem)

Vue.prototype.$message = Message;