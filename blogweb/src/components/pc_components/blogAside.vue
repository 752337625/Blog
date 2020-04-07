<template>
  <div class="blogAsideConainer">
    <el-menu
      default-active="/odometer"
      :collapse-transition="true"
      :unique-opened="true"
      background-color="#263238"
      text-color="#fff"
      active-text-color="#ffd04b"
      style="border: 0;"
      router
    >
      <el-submenu v-for="(item ,index) in menuItem" :index="item.index" :key="index">
        <template slot="title">
          <i :class="item.icon"></i>
          <span slot="title">{{item.text}}</span>
        </template>
        <el-menu-item v-for="(children,key) in item.children" :index="children.index" :key="key">
          <template>
            <i :class="children.icon"></i>
            <span>{{children.text}}</span>
          </template>
        </el-menu-item>
      </el-submenu>
    </el-menu>
  </div>
</template>

<script>
export default {
  data: function() {
    return {
      menuItem: [
        {
          index: "/odometer",
          text: "仪表盘",
          icon: "el-icon-odometer",
          children: []
        },
        {
          index: "/1",
          text: "菜单管理",
          icon: "el-icon-odometer",
          children: []
        },
        {
          index: "/2",
          text: "广告管理",
          icon: "el-icon-odometer",
          children: []
        },
        {
          index: "/3",
          text: "留言管理",
          icon: "el-icon-odometer",
          children: []
        },
        {
          index: "/6",
          text: "文章管理",
          icon: "el-icon-document",
          children: [
            { index: "/addBlog", text: "新增文章", icon: "el-icon-document" },
            {
              index: "/listOperationBlog",
              text: "文章列表",
              icon: "el-icon-document"
            },
            {
              index: "/7",
              text: "文章列表",
              icon: "el-icon-document"
            },
            {
              index: "/8",
              text: "文章列表",
              icon: "el-icon-document"
            }
          ]
        },
        {
          index: "/9",
          text: "文章管理",
          icon: "el-icon-document",
          children: [
            { index: "/addBlog", text: "新增文章", icon: "el-icon-document" },
            {
              index: "/listOperationBlog",
              text: "文章列表",
              icon: "el-icon-document"
            },
            {
              index: "/10",
              text: "文章列表",
              icon: "el-icon-document"
            },
            {
              index: "/11",
              text: "文章列表",
              icon: "el-icon-document"
            }
          ]
        },
        {
          index: "/user",
          text: "博主管理",
          icon: "el-icon-user-solid",
          children: [
            {
              index: "/blogUserAdd",
              text: "博主新增",
              icon: "el-icon-user-solid"
            },
            {
              index: "/blogUserList",
              text: "博主列表",
              icon: "el-icon-user-solid"
            }
          ]
        }
      ]
    };
  },
  components: {},
  methods: {
    handleOpen(key, keyPath) {
      //console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      //console.log(key, keyPath);
    }
  }
};
</script>

<style lang="less" scoped>
.blogAsideConainer {
  height: 100%;
  .el-menu {
    height: 100%;
  }
}
.el-submenu .el-menu-item {
  min-width: auto;
}
</style>
