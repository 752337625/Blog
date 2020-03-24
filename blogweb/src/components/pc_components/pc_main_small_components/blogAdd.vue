<template>
  <div class="mainConainer">
    <BlogBreadCrumb :BreadCrumbInfo="BreadCrumbInfo"></BlogBreadCrumb>

    <el-card class="box-card ql-container ql-snow">
      <quill-editor v-model="content" :options="editorOption" ></quill-editor>
    </el-card>
  </div>
</template>

<script>
import BlogBreadCrumb from "./blogBreadCrumb";
//悬浮显示富文本
import { addQuillTitle } from "../../../assets/js/quill-title.js";
export default {
  data: function() {
    return {
      content: "",
      editorOption: {
        
      },
      BreadCrumbInfo: {
        Home: "首页",
        LevelOneMenu: "文章管理",
        LevelTwoMenu: "新增文章"
      }
    };
  },
  mounted: function() {
    //悬浮显示title
    addQuillTitle();
  },
  components: {
    BlogBreadCrumb
  },
  methods: {}
};
</script>

<style lang="less" scoped>


</style>
