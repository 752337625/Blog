<template>
  <div class="tableHigth" :style="{height:(tableInfo.height-90)+'px'}">
    <el-table :data="tableInfo.tableData" style="width: 100%" border height="100%">
      <el-table-column
        v-for="(param,key) in tableInfo.tableParam"
        :key="key"
        :prop="param.prop"
        :label="param.label"
        :width="param.width"
      ></el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <i class="el-icon-view" @click="handleClick(scope.row)"></i>
          <i class="el-icon-edit-outline" @click="handleClick(scope.row)"></i>
          <i class="el-icon-delete" @click="handleClick(scope.row)"></i>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination background layout="prev, pager, next" :total="1000"></el-pagination>
  </div>
</template>
<script>
export default {
  props: ["tableInfo"],
  data: function() {
    return {};
  },
  mounted() {},
  components: {},
  methods: {}
};
</script>

<style lang="less" scoped>
.tableHigth{
  i:first-child{
      margin-left: 0px;
  }
  i{
    margin: 0 10px;
    font-size: 17px;
    color: #409EFF;
    &:hover{
      background-color: #E7EAED;
      cursor: pointer;
    }
  }
  
}
.el-pagination {
  padding-top: 12px;
  padding-bottom: 10px;
  float: right;
 
}
</style>
