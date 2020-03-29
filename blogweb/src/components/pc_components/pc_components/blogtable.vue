<template>
  <div class="tableHigth">
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
  </div>
</template>
<script>
export default {
  props: ["tableInfo"],
  data: function() {
    return {};
  },
  components: {},
  methods: {}
};
</script>

<style lang="less" scoped>
</style>
