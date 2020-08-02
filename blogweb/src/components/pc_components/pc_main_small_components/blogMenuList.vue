<template>
  <div class="mainConainer mainDisplay">
    <Breadcrumb :breadcrumb="breadcrumb"></Breadcrumb>
    <CardUserList :tableInfo="tableInfo"></CardUserList>
  </div>
</template>
<script>
import Breadcrumb from "../pc_components/breadcrumb";
import CardUserList from "../pc_components/cardUserList";
export default {
  data: function() {
    return {
      breadcrumb: {
        to: "首页",
        LevelOneto: "菜单管理",
        LevelTwoto: "菜单列表"
      },
      tableInfo: {
        tableParam: [
          {
            label: "用户名",
            prop: "name",
            width: ""
          },
          {
            label: "创建日期",
            prop: "createDate",
            width: ""
          },
          {
            label: "角色",
            prop: "role",
            width: ""
          },
          {
            label: "IP",
            prop: "IP",
            width: ""
          },
          {
            label: "用户活跃状态",
            prop: "state",
            width: ""
          }
        ],
        tableData: [
          {
            name: "王小虎",
            createDate: "2016-05-02",
            address: "上海市普陀区金沙江路 1518 弄",
            role: "超级管理员,普通管理员",
            IP: "127.16.10.11",
            state: "新增"
          },{
            name: "王小虎",
            createDate: "2016-05-02",
            address: "上海市普陀区金沙江路 1518 弄",
            role: "超级管理员,普通管理员",
            IP: "127.16.10.11",
            state: "新增"
          },{
            name: "王小虎",
            createDate: "2016-05-02",
            address: "上海市普陀区金沙江路 1518 弄",
            role: "超级管理员,普通管理员",
            IP: "127.16.10.11",
            state: "新增"
          },{
            name: "王小虎",
            createDate: "2016-05-02",
            address: "上海市普陀区金沙江路 1518 弄",
            role: "超级管理员,普通管理员",
            IP: "127.16.10.11",
            state: "新增"
          },{
            name: "王小虎",
            createDate: "2016-05-02",
            address: "上海市普陀区金沙江路 1518 弄",
            role: "超级管理员,普通管理员",
            IP: "127.16.10.11",
            state: "新增"
          },{
            name: "王小虎",
            createDate: "2016-05-02",
            address: "上海市普陀区金沙江路 1518 弄",
            role: "超级管理员,普通管理员",
            IP: "127.16.10.11",
            state: "新增"
          },{
            name: "王小虎",
            createDate: "2016-05-02",
            address: "上海市普陀区金沙江路 1518 弄",
            role: "超级管理员,普通管理员",
            IP: "127.16.10.11",
            state: "新增"
          },{
            name: "王小虎",
            createDate: "2016-05-02",
            address: "上海市普陀区金沙江路 1518 弄",
            role: "超级管理员,普通管理员",
            IP: "127.16.10.11",
            state: "新增"
          },{
            name: "王小虎",
            createDate: "2016-05-02",
            address: "上海市普陀区金沙江路 1518 弄",
            role: "超级管理员,普通管理员",
            IP: "127.16.10.11",
            state: "新增"
          },{
            name: "王小虎",
            createDate: "2016-05-02",
            address: "上海市普陀区金沙江路 1518 弄",
            role: "超级管理员,普通管理员",
            IP: "127.16.10.11",
            state: "新增"
          },{
            name: "王小虎",
            createDate: "2016-05-02",
            address: "上海市普陀区金沙江路 1518 弄",
            role: "超级管理员,普通管理员",
            IP: "127.16.10.11",
            state: "新增"
          },{
            name: "王小虎",
            createDate: "2016-05-02",
            address: "上海市普陀区金沙江路 1518 弄",
            role: "超级管理员,普通管理员",
            IP: "127.16.10.11",
            state: "新增"
          },{
            name: "王小虎",
            createDate: "2016-05-02",
            address: "上海市普陀区金沙江路 1518 弄",
            role: "超级管理员,普通管理员",
            IP: "127.16.10.11",
            state: "新增"
          },{
            name: "王小虎",
            createDate: "2016-05-02",
            address: "上海市普陀区金沙江路 1518 弄",
            role: "超级管理员,普通管理员",
            IP: "127.16.10.11",
            state: "新增"
          },{
            name: "王小虎",
            createDate: "2016-05-02",
            address: "上海市普陀区金沙江路 1518 弄",
            role: "超级管理员,普通管理员",
            IP: "127.16.10.11",
            state: "新增"
          },{
            name: "王小虎",
            createDate: "2016-05-02",
            address: "上海市普陀区金沙江路 1518 弄",
            role: "超级管理员,普通管理员",
            IP: "127.16.10.11",
            state: "新增"
          },{
            name: "王小虎",
            createDate: "2016-05-02",
            address: "上海市普陀区金沙江路 1518 弄",
            role: "超级管理员,普通管理员",
            IP: "127.16.10.11",
            state: "新增"
          },{
            name: "王小虎",
            createDate: "2016-05-02",
            address: "上海市普陀区金沙江路 1518 弄",
            role: "超级管理员,普通管理员",
            IP: "127.16.10.11",
            state: "新增"
          },{
            name: "王小虎",
            createDate: "2016-05-02",
            address: "上海市普陀区金沙江路 1518 弄",
            role: "超级管理员,普通管理员",
            IP: "127.16.10.11",
            state: "新增"
          },
        ],
        height:'400',
      }
       
    };
  },
  components: {
    Breadcrumb,
    CardUserList
  },
  mounted(){
   this.tableInfo.height=(document.getElementsByClassName('mainConainer')[0].clientHeight-50);
  },
  methods: {
   
  }
};
</script>

<style lang="less" scoped>

</style>
