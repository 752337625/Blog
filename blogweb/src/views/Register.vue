<template>
  <div class="loginConainer">
    <el-col :xs="5" :sm="8" :md="8" :lg="7" :xl="9" class="loginForm pa">
      <h1>后台管理系统</h1>
      <el-form label-position="left" :model="userInfo" :rules="rules" ref="ruleForm" size="medium">
        <el-form-item prop="userName">
          <el-input
            v-model="userInfo.userName"
            prefix-icon="iconfont iconuser_login"
            clearable
            placeholder="真实姓名或常用昵称"
          ></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input
            v-model="userInfo.password"
            prefix-icon="iconfont iconpass"
            show-password
            clearable
            placeholder="不小于6位的密码"
          ></el-input>
        </el-form-item>
        <el-form-item prop="telephone">
          <el-input
            v-model="userInfo.telephone"
            prefix-icon="iconfont icondianhua3"
            clearable
            placeholder="11位手机号"
          ></el-input>
        </el-form-item>
        <el-form-item prop="email">
          <el-input
            v-model="userInfo.email"
            prefix-icon="iconfont iconyouxiang1"
            clearable
            placeholder="请输入邮箱"
          ></el-input>
        </el-form-item>
        <el-form-item prop="clause">
          <el-button type="primary" @click="submitForm('ruleForm')" size="medium">提交</el-button>
          <el-checkbox v-model="userInfo.clause" true-label=1 false-label=0>同意</el-checkbox>
          <router-link class="registerStyle" to="/">《服务条款》、《隐私政策》</router-link>
        </el-form-item>
      </el-form>
    </el-col>
  </div>
</template>

<script>
export default {
  data: function() {
    return {
      userInfo: {
        userName: "",
        password: "",
        telephone: "",
        email: "",
        IP: returnCitySN["cip"],
        address: returnCitySN["cname"],
        enabled: 1,
        locked: 1,
        clause: true
      },
      rules: {
        userName: [
          {
            required: true,
            message: "长度在 3 到 5 个字符",
            trigger: "blur"
          },
          {
            min: 3,
            max: 5,
            message: "长度在 3 到 5 个字符",
            trigger: "blur"
          }
        ],
        password: [
          {
            required: true,
            message: "6~16个字符，区分大小写",
            trigger: "blur"
          },
          {
            min: 6,
            max: 16,
            message: "6~16个字符，区分大小写",
            trigger: "blur"
          }
        ],
        telephone: [
          {
            required: true,
            message: "请输入11位手机号",
            trigger: "blur"
          },
          {
            min: 11,
            max: 11,
            message: "11位手机号",
            trigger: "blur"
          }
        ],
        email: [
          {
            required: true,
            message: "6~18个字符，可使用字母、数字、下划线，需以字母开头",
            trigger: "blur"
          },
          {
            min: 6,
            max: 18,
            message: "6~18个字符，可使用字母、数字、下划线，需以字母开头",
            trigger: "blur"
          }
        ],
        clause: [
          {
            required: true,
            message: "请接受《服务条款》和《隐私政策》",
            trigger: "change"
          },
          {
            message: "请接受《服务条款》和《隐私政策》",
            trigger: "change"
          }
        ]
      }
    };
  },
  mounted() {},
  methods: {
    submitForm(formName) {
      let _this = this;
      this.$refs[formName].validate(async valid => {
        if (!valid) return false;
        const { data: res } = await this.$http.post(
          "/register",
          this.$qs.stringify(this.userInfo)
        );
        if (res.statue != 200) return this.$message.error(res.message);
        this.$message({
          message: "保存成功，三秒后自动跳转",
          center: true,
          type: "success",
          duration: 3000,
          onClose: function() {
            _this.$router.push("/Login");
          }
        });
      });
    }
  }
};
</script>

<style lang="less" scoped>
.loginConainer {
  background-image: url(../assets/img/login1.jpg);
  background-repeat: no-repeat;
  background-size: 100% 100%; //不兼容ie8以下
  .loginForm {
    min-width: 450px;
    background-color: rgba(255, 255, 255, 0.4);
    //opacity: 0.5;
    transform: translate(
      -50%,
      -50%
    ); //CSS3 2D Transforms ie8一下不支持,9需要添加前缀
    top: 50%;
    left: 50%;
    text-align: center;
    h1 {
      padding: 10px 0;
    }
  }
  .el-form {
    width: 80%;
    margin: auto;
    & > div {
      padding-bottom: 30px;
      &:last-child{
          padding-bottom: 40px;
      }
       &:nth-last-child(2){
          padding-bottom: 40px;
      }
    }
    .el-form-item {
      margin-bottom: 0;
      text-align: left;
    }
    .el-button {
      width: 120px;
      margin: 0 30px 0 0;
    }
    .registerStyle {
      float: right;
      text-decoration: none;
      color: #039;
      font-size: 12px;
       &:hover{
            text-decoration: underline;
       }
    }
  }
}
</style>
