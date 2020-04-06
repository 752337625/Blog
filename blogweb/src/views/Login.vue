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
            placeholder="用户名"
          ></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input
            v-model="userInfo.password"
            prefix-icon="iconfont iconpass"
            show-password
            clearable
            placeholder="密码"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')" size="medium">登录</el-button>
          <el-checkbox v-model="checked">记住密码</el-checkbox>
          <router-link class="registerStyle" to="/Register">忘记密码</router-link>
          <router-link class="registerStyle" to="/Register">注册|</router-link>
        </el-form-item>
      </el-form>
    </el-col>
  </div>
</template>

<script>
import AMap from "AMap"; // 引入高德地图
export default {
  data: function() {
    return {
      checked: false,
      userInfo: {
        userName: "",
        password: "",
        IP: returnCitySN["cip"],
        address: returnCitySN["cname"],
      },
      rules: {
        userName: [
          {
            required: true,
            min: 3,
            max: 5,
            message: "长度在 3 到 5 个字符",
            trigger: "blur"
          }
        ],
        password: [
          {
            required: true,
            min: 6,
            max: 16,
            message: "长度在 6到 16个字符",
            trigger: "blur"
          }
        ]
      }
    };
  },
  mounted() {
    this.getLocation();
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate(async valid => {
        if (!valid) return false;
        const { data: res } = await this.$http.post(
          "/LoginData",
          this.$qs.stringify(this.userInfo)
        );
        //if (res.statue != 200) return this.$message.error(res.message);
        window.sessionStorage.setItem("token", "555555555");
        this.$router.push("/Home");
      });
    },

    getLocation() {
      const self = this;
      AMap.plugin("AMap.Geolocation", function() {
        var geolocation = new AMap.Geolocation({
          // 是否使用高精度定位，默认：true
          enableHighAccuracy: true,
          // 设置定位超时时间，默认：无穷大
          timeout: 10000
        });

        geolocation.getCurrentPosition();
        AMap.event.addListener(geolocation, "complete", onComplete);
        AMap.event.addListener(geolocation, "error", onError);

        function onComplete(data) {
          // data是具体的定位信息
          console.log("定位成功信息：", data);
        }

        function onError(data) {
          // 定位出错
          console.log("定位失败错误：", data);
          // 调用ip定位
          self.getLngLatLocation();
        }
      });
    },
    getLngLatLocation() {
      AMap.plugin("AMap.CitySearch", function() {
        var citySearch = new AMap.CitySearch();
        citySearch.getLocalCity(function(status, result) {
          console.log(status, result);
          if (status === "complete" && result.info === "OK") {
            // 查询成功，result即为当前所在城市信息
            console.log("通过ip获取当前城市：", result);
            //逆向地理编码
            AMap.plugin("AMap.Geocoder", function() {
              var geocoder = new AMap.Geocoder({
                // city 指定进行编码查询的城市，支持传入城市名、adcode 和 citycode
                city: result.adcode
              });

              var lnglat = result.rectangle.split(";")[0].split(",");
              geocoder.getAddress(lnglat, function(status, data) {
                if (status === "complete" && data.info === "OK") {
                  // result为对应的地理位置详细信息
                  console.log(data);
                }
              });
            });
          }
        });
      });
    }
  }
};
</script>

<style lang="less" scoped>
.loginConainer {
  background-image: url(../assets/img/login.jpg);
  background-repeat: no-repeat;
  background-size: 100% 100%; //不兼容ie8以下
  .loginForm {
    min-width: 440px;
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
      color: #ccc;
      &:hover {
        color: #409eff;
      }
    }
  }
}
</style>
