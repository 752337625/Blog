<template>
  <div class="blogHeadConainer">
    <el-row type="flex" justify="space-between">
      <el-row type="flex">
        <el-col >
          <i class="iconfont iconmianbaoxie" @click="showCard('menuListInfo')"></i>
        </el-col>
        <el-col>
          <i class="iconfont iconnotificationbellring"  @click="showCard('messageInfo')"></i>
        </el-col>
        <el-col >
          <i class="iconfont iconicon-" @click="showCard('menuInfo')"></i>
        </el-col>
      </el-row>
      <el-row type="flex">
        <el-col  style="border-left: 1px solid rgba(0, 0, 0, 0.05);">
          <i class="iconfont icon24gl-portraitMale" @click="showCard('userInfo')"></i>
        </el-col>
        <el-col>
          <i class="iconfont iconmianbaoxie"></i>
        </el-col>
        <el-col style="border-left: 0;">
          <i class="iconfont icondots-vertical"></i>
        </el-col>
      </el-row>
    </el-row>
    <blogHeadCard v-show="visible" :info="info" :client="client"></blogHeadCard>
  </div>
</template>

<script>
import blogHeadCard from "./pc_header_small_components/blogHeaderCard";
export default {
  data: function() {
    return {
      visible: false,
      isCollapse: false,
      userInfo: {
        name: "王宏伟",
        age: 36,
        adder: "奶东村"
      },
      client: {
        clientX: "",
        clientY: ""
      },
      menuInfo: {
        name: "海贼王"
      },
      messageInfo: {
        name: "王家卫"
      },
      info: ""
    };
  },
  components: {
    blogHeadCard
  },
  methods: {
    showCard(mess) {
      console.log(1)
      if (mess == "menuListInfo") {
        this.$emit("ShowMenuListInfo", !this.isCollapse); //自定义事件  传递值“子向父组件传值”
        this.isCollapse = !this.isCollapse;
        return;
      }
      this.visible = !this.visible;
      this.client.clientX = event.clientX - event.offsetX + "px";
      this.client.clientY = "50px";
      this.info = this.$data[mess];
      event.preventDefault();
    }
  }
};
</script>

<style lang="less" scoped>
.iconfont {
  color: #758697;
}
.blogHeadConainer,
.blogHeadConainer > div,
i {
  height: 100%;
}
.blogHeadConainer > div > div div {
  width: 50px;
  border-right: 1px solid rgba(0, 0, 0, 0.05);
  text-align: center;
}
.iconfont {
  font-size: 30px;
  display: block;
  line-height: 45px;
}
.iconfont:hover {
  cursor: pointer;
}
// .blogHeadConainer,
// .navbar-header,
// .navbar-header div,
// .navbar-header-left,
// .navbar-header-rigth {
//   height: 100%;
//   line-height: 45px;
// }

// .iconmianbaoxie,
// .iconmenu-line,
// .icondengluyemianyonghuming,
// .iconicon- {
//   font-size: 1.9rem;
//   line-height: 45px;
//   display: block;
// }

// .menu-icon {
//   text-align: right;
// }

// .blogger {
//   display: flex;
//   padding-left: 1.4rem;
// }

// .iconfontContent {
//   display: flex;
//   justify-content: space-between;
// }

// .iconblogger {
//   font-size: 1.9rem;
//   padding-right: 0.6rem;
//   display: block;
// }

// .iconfontContent .portraitMale {
//   display: flex;
//   width: auto;
//   color: #758697;
//   border-left: 1px solid rgba(0, 0, 0, 0.05);
// }

// .blogger p {
//   font-size: 1.9rem;
//   line-height: 45px;
// }

// .navbar-header-left {
//   background-color: #263238;
//   color: white;
// }

// .navbar-header-rigth {
//   background: white;
// }

// .iconfontBorder {
//   display: flex;
// }

// .iconfontContent .iconfontBorder > div:hover {
//   background-color: #f2f2f2;
//   cursor: pointer;
// }

// .iconfontBorder > div {
//   border-right: 1px solid rgba(0, 0, 0, 0.05);
//   width: 50px;
//   text-align: center;
// }

// .iconfontBorder > div i {
//   font-size: 1.9rem;
//   color: #758697;
//   line-height: 45px;
//   display: block;
// }
</style>
