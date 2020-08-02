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
    Table,
    TableColumn,
    Pagination,
    Divider,
    Backtop,
    Loading,
    DatePicker,
    Select,
    Option,
    Tabs,
    TabPane,
    Tag,
    TimeSelect,
    TimePicker,
    Switch,
    CheckboxGroup,
    CheckboxButton,
    Checkbox,
    RadioButton,
    RadioGroup,
    Radio,
} from 'element-ui';
//Layout 布局隐藏
import 'element-ui/lib/theme-chalk/display.css';
Vue.use(Radio);
Vue.use(RadioGroup);
Vue.use(RadioButton);
Vue.use(Checkbox);
Vue.use(CheckboxButton);
Vue.use(CheckboxGroup);

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
Vue.use(Table)
Vue.use(TableColumn)
Vue.use(Pagination)
Vue.use(Divider)
Vue.use(Backtop)
Vue.use(DatePicker);
Vue.use(Select);
Vue.use(Option);
Vue.use(Tabs);
Vue.use(TabPane);
Vue.use(TimePicker);
Vue.use(Switch);
Vue.prototype.$message = Message;