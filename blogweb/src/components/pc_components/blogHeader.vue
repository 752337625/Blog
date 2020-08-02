<template>
  <div class="blogHeadConainer">
    <el-row>
      <ul>
        <li>
          <router-link to="/Home">后台管理系统</router-link>
        </li>
        <li>
          <i class="iconfont iconmianbaoxie" @click="showCard('menuListInfo')"></i>
        </li>
        <li>
          <i class="iconfont iconnotificationbellring" @click="showCard('menuInfo')"></i>
        </li>
        <li>
          <i class="iconfont iconicon-" @click="showCard('menuInfo')"></i>
        </li>
        <li>
          <i class="iconfont icondots-vertical"></i>
        </li>
        <li>
          <i class="iconfont iconmianbaoxie"></i>
        </li>
        <li>
          <i class="iconfont icon24gl-portraitMale" @click="showCard('userInfo')"></i>
        </li>
      </ul>
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
.blogHeadConainer {
  background-color: #001529;
  ul {
    width: 100%;
    height: 45px;
    line-height: 45px;
    li:not(:first-child) {
      width: 50px;
      text-align: center;
    }
    li {
      float: left;
      border-right: 1px solid #2fb9d4;
      a {
        color: #ffffff;
      }
      &:first-child {
        width: 174px;
        font-size: 18px;
        font-weight: 700;
        padding-left: 26px;
      }
      &:nth-last-child(2) {
        float: right;
      }
      &:nth-last-child(3) {
        border-right: 0;
        float: right;
      }
      &:last-child {
        float: right;
        border-left: 1px solid #2fb9d4;
      }
      .iconfont {
        color: #ffffff;
        font-size: 25px;
        &:hover {
          cursor: pointer;
        }
      }
    }
  }
}
// .blogHeadConainer {
//    background-color: #fff;
//   div {
//     height: 100%;
//     border-right: 1px solid rgba(0, 0, 0, 0.05);
//     div div{
//       width: 50px;
//     }
//   }
//   .iconfont {
//     color: #758697;
//     font-size: 30px;
//     line-height: 45px;
//     display: block;
//     text-align: center;
//     &:hover{
//       cursor: pointer;
//     }
//   }
// }
</style>
