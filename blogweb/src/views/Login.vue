<template>
  <div class="loginConainer">
    <el-row type="flex" justify="center">
      <el-col :xs="21" :sm="10" :md="8" :lg="6" :xl="7" class="loginboxItem">
        <el-row type="flex" justify="center">
          <el-col :xs="18" :sm="17" :md="16" :lg="15" :xl="15">
            <h1>后台管理系统</h1>
          </el-col>
        </el-row>
        <el-form
          label-position="top"
          label-width="80px"
          :model="userInfo"
          :rules="rules"
          ref="ruleForm"
        >
          <el-row type="flex" justify="center">
            <el-col :xs="18" :sm="17" :md="16" :lg="15" :xl="15">
              <el-form-item label prop="name">
                <el-input v-model="userInfo.name" prefix-icon="iconfont iconuser_login"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row type="flex" justify="center">
            <el-col :xs="18" :sm="17" :md="16" :lg="15" :xl="15">
              <el-form-item label prop="pass">
                <el-input v-model="userInfo.pass" prefix-icon="iconfont iconpass" show-password></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row type="flex" justify="center">
            <el-col :xs="18" :sm="17" :md="16" :lg="15" :xl="15" class="buttonPosition">
              <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
                <el-button type="info" @click="resetForm('ruleForm')">重置</el-button>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  data: function() {
    return {
      userInfo: {
        name: "",
        pass: ""
      },
      rules: {
        name: [
          {
            required: true,
            message: "请输入用户名",
            trigger: "blur"
          },
          {
            min: 3,
            max: 5,
            //message: '设置后不可更改，中英文均可，最长14个英文或7个汉字',
            message: "用户名不存在,最长14个英文或7个汉字",
            trigger: "blur"
          }
        ],
        pass: [
          {
            required: true,
            message: "请输入密码",
            trigger: "blur"
          },
          {
            min: 6,
            max: 20,
            //message: '支持6-20位的数字、字母、符号或任意组合',
            message: "请6-20位的密码",
            trigger: "blur"
          }
        ]
      }
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate(async valid => {
        if (!valid) return false;
        // const {
        //     data: res
        // } = await this.$http.post("login.e", this.userInfo)
        // if(res.mess.statue!=200)return this.$message.error('用户名和密码不正确,请重新登录')
        window.sessionStorage.setItem("token", "555555555");
        this.$router.push("/Home");
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
};
</script>

<style lang="less" scoped>
.loginConainer {
  width: 100%;
  height: 100%;
  background-image: url(../assets/img/login.jpg);
  background-repeat: no-repeat;
  background-size: 100% 100%;
  background-clip: border-box;
}

.loginbox,
.loginConainer > div {
  height: 100%;
}

.loginboxItem {
  background: white;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  border-radius: 0.1rem;
  box-shadow: 0px 0px 15px #545454;
}

h1 {
  text-align: center;
  color: #409eff;
  margin-block-start: 0.67em;
  margin-block-end: 0.67em;
  font-size: 30px;
}

.buttonPosition {
  text-align: center;
}
</style>
