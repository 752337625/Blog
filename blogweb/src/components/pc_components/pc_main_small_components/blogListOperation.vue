<template>
  <div class="mainConainer">
    <BlogBreadCrumb :BreadCrumbInfo="BreadCrumbInfo"></BlogBreadCrumb>
    <el-card >
      <el-row style="margin-bottom: 10px;">
        <el-col :span="24">
          <BlogTable :columnInfo="columnInfo" :columnData="columnData"></BlogTable>
        </el-col>
      </el-row>
      <el-row type="flex" justify="end" align="middle">
        <el-pagination background layout="prev, pager, next" :total="1000"></el-pagination>
      </el-row>
    </el-card>
  </div>
</template>

<script>
import BlogBreadCrumb from "./blogBreadCrumb";
import BlogTable from "./pc_small_components/blogTable";
export default {
  data: function() {
    return {
      labelPosition: "right",
      formLabelAlign: {
        name: "",
        region: "",
        type: ""
      },
      BreadCrumbInfo: {
        Home: "首页",
        LevelOneMenu: "文章管理",
        LevelTwoMenu: "文章列表"
      },
      columnInfo: [
        {
          prop: "name",
          label: "作者",
          width: "100"
        },
        {
          prop: "blog",
          label: "标题",
          width: ""
        },
        {
          prop: "desc",
          label: "描述",
          width: ""
        },
        {
          prop: "createTime",
          label: "创建时间",
          width: "100"
        },
        {
          prop: "updateTime",
          label: "更新时间",
          width: "100"
        }
      ],
      columnData: [{
        name:'5',
        blog:'5',
        desc:'5',
        createTime:'5',
        updateTime:'5',
      }, {
        name:'5',
        blog:'5',
        desc:'5',
        createTime:'5',
        updateTime:'5',
      },{
        name:'5',
        blog:'5',
        desc:'5',
        createTime:'5',
        updateTime:'5',
      },{
        name:'5',
        blog:'5',
        desc:'5',
        createTime:'5',
        updateTime:'5',
      },{
        name:'5',
        blog:'5',
        desc:'5',
        createTime:'5',
        updateTime:'5',
      },{
        name:'5',
        blog:'5',
        desc:'5',
        createTime:'5',
        updateTime:'5',
      },{
        name:'5',
        blog:'5',
        desc:'5',
        createTime:'5',
        updateTime:'5',
      },{
        name:'5',
        blog:'5',
        desc:'5',
        createTime:'5',
        updateTime:'5',
      },{
        name:'5',
        blog:'5',
        desc:'5',
        createTime:'5',
        updateTime:'5',
      }]
    };
  },
  components: {
    BlogBreadCrumb,
    BlogTable
  }
};
</script>

<style lang="less" scoped>
// .box-card {
//   //min-height: 627px;
// }
// .el-form-item--mini.el-form-item {
//   margin-bottom: 0px;
// }
// .el-form-item {
//   margin-bottom: 0px;
// }
// .el-form.el-form--label-right.el-form--inline {
//   display: flex;
//   justify-content: start;
//   align-items: center;
// }
.mainConainer{
  height: 100%;
}
.el-card{
      height: 87%;
}
</style>
