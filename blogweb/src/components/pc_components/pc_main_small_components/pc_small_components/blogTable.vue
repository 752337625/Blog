<template>
<div class="">
  <el-table :data="columnData" style="width: 100%" stripe border highlight-current-row >
    <el-table-column  v-for="(column,index) in columnInfo" :key="index" :prop=column.prop  :label=column.label  :width=column.width></el-table-column>
  </el-table>
</div>
</template>

<script>
export default {
  props:['columnInfo','columnData'],
  data: function () {
    return {
     
    };
  },
  components: {},
  methods: {}
};
</script>

<style lang="less" scoped>
</style>
