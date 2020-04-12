<template>
  <div class="mainConainer mainDisplay">
    <Breadcrumb :breadcrumb="breadcrumb"></Breadcrumb>
    <div class="cardClass" style="overflow: auto">
      <el-form
        :model="ruleForm"
        :rules="rules"
        ref="ruleForm"
        label-width="120px"
        class="demo-ruleForm"
      >
        <el-col :span="24">
          <el-form-item label="用户名" prop="userName">
            <el-col :span="15">
              <el-input v-model="ruleForm.userName"></el-input>
            </el-col>
          </el-form-item>
          <el-form-item label="密码" prop="password" show-password>
            <el-col :span="15">
              <el-input v-model="ruleForm.password"></el-input>
            </el-col>
          </el-form-item>
            <el-form-item label="邮箱" prop="email">
            <el-col :span="15">
              <el-input v-model="ruleForm.email"></el-input>
            </el-col>
          </el-form-item>
             <el-form-item label="电话" prop="telephone">
            <el-col :span="15">
              <el-input v-model="ruleForm.telephone"></el-input>
            </el-col>
          </el-form-item>
          <!--   <el-form-item label="帐号状态" prop="delivery">
          <el-switch v-model="ruleForm.delivery"></el-switch>
          </el-form-item>-->
          <!-- <el-form-item label="帐号状态" prop="region">
          <el-select v-model="ruleForm.region" placeholder="请选择帐号状态">
            <el-option label="禁用" value="shanghai"></el-option>
            <el-option label="可用" value="beijing"></el-option>
          </el-select>
          </el-form-item>-->
          <!-- <el-form-item label="用户活跃状态" prop="region">
            <el-col :span="15">
              <el-select v-model="ruleForm.region" placeholder="请选择用户活跃状态">
                <el-option label="新增" value="new"></el-option>
                <el-option label="活跃" value="active"></el-option>
                <el-option label="沉默" value="silence"></el-option>
                <el-option label="回流" value="backflow"></el-option>
                <el-option label="流失" value="loss"></el-option>
              </el-select>
            </el-col>
          </el-form-item> -->
          <el-form-item label="帐号状态" prop="enabled">
            <el-col :span="15">
              <el-switch v-model="ruleForm.enabled"></el-switch>
            </el-col>
          </el-form-item>
           <el-form-item label="帐号是否被锁定" prop="locked">
            <el-col :span="15">
              <el-switch v-model="ruleForm.locked"></el-switch>
            </el-col>
          </el-form-item>
          <!-- <el-form-item label="爱好" prop="type">
            <el-col :span="24">
              <el-checkbox-group v-model="ruleForm.type">
                <el-checkbox label="运动类" name="type"></el-checkbox>
                <el-checkbox label="娱乐类" name="type"></el-checkbox>
                <el-checkbox label="冒险类" name="type"></el-checkbox>
                <el-checkbox label="游戏类" name="type"></el-checkbox>
                <el-checkbox label="智力类" name="type"></el-checkbox>
                <el-checkbox label="收藏类" name="type"></el-checkbox>
                <el-checkbox label="乐器类" name="type"></el-checkbox>
                <el-checkbox label="文艺类" name="type"></el-checkbox>
                <el-checkbox label="网游" name="type"></el-checkbox>
                <el-checkbox label="返老还童类" name="type"></el-checkbox>
              </el-checkbox-group>
            </el-col>
          </el-form-item> -->
          <!-- <el-form-item label="特殊资源" prop="resource">
          <el-radio-group v-model="ruleForm.resource">
            <el-radio label="线上品牌商赞助"></el-radio>
            <el-radio label="线下场地免费"></el-radio>
          </el-radio-group>
          </el-form-item>-->
          <el-form-item label="个人描述" prop="desc">
            <el-col :span="15">
              <el-input type="textarea" v-model="ruleForm.desc" maxlength="30"></el-input>
            </el-col>
          </el-form-item>
          <el-form-item>
            <el-col :span="15">
              <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
              <el-button @click="resetForm('ruleForm')">重置</el-button>
            </el-col>
          </el-form-item>
        </el-col>
      </el-form>
    </div>
  </div>
</template>

<script>
import Breadcrumb from "../pc_components/breadcrumb";
export default {
  data() {
    return {
      breadcrumb: {
        to: "首页",
        LevelOneto: "博主管理",
        LevelTwoto: "新增用户"
      },
      ruleForm: {
        userName: "",
        password: "",
        enabled: "",
        clause:  true,
        locked:  true,
        telephone:"",
        email:"",
        desc: "",
        address:"",
        IP:""
      },
      rules: {
        name: [
          { required: true, message: "请输入活动名称", trigger: "blur" },
          { min: 3, max: 5, message: "长度在 3 到 5 个字符", trigger: "blur" }
        ],
        pass: [
          { required: true, message: "请输入密码", trigger: "blur" },
          { min: 3, max: 5, message: "长度在 6 到 14 个字符", trigger: "blur" }
        ],
        region: [
          { required: true, message: "请选择活动区域", trigger: "change" }
        ],
        date1: [
          {
            type: "date",
            required: true,
            message: "请选择日期",
            trigger: "change"
          }
        ],
        date2: [
          {
            type: "date",
            required: true,
            message: "请选择时间",
            trigger: "change"
          }
        ],
        type: [
          {
            type: "array",
            required: true,
            message: "请至少选择一个活动性质",
            trigger: "change"
          }
        ],
        resource: [
          { required: true, message: "请选择活动资源", trigger: "change" }
        ],
        desc: [{ required: true, message: "请填写活动形式", trigger: "blur" }]
      }
    };
  },
  components: {
    Breadcrumb
  },
   mounted: function () {
      var date = new Date();
      console.log(this)
      console.log(this.$date.dateTime(date))
     // console.log(Vue.prototype.$date.dateTime(date));
      //return;
    
  },
  methods: {
    //组件调用全局方法
    dateTime() {
      var date = new Date();
      return this.$date.dateTime(date);
    },
    submitForm(formName) {
      this.$router.push("/blogUserList");
      // this.$refs[formName].validate(valid => {
      //   if (valid) {
      //     alert("submit!");
      //   } else {
      //     console.log("error submit!!");
      //     return false;
      //   }
      // });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
};
</script>

<style lang="less" scoped>
.demo-ruleForm {
  display: flex;
  justify-content: center;
}
</style>
