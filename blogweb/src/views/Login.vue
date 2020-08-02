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
          <el-checkbox v-model="rememberMe">记住密码</el-checkbox>
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
  beforeCreate:function(){
    document.cookie.split(';').forEach(function(item){
      if(item.trim().indexOf("BLOGUSERNAME")>-1){
         window.BLOGUSERNAME=item.trim().substring(13)
      }else if(item.trim().indexOf("BLOGPASSWORD")>-1){
         window.BLOGPASSWORD=item.trim().substring(13)
      }
    })
  },
  data: function() {
    return {
       rememberMe:true,
        userInfo: {
        userName: window.BLOGUSERNAME||'',
        password: window.BLOGPASSWORD||'',
        IP: returnCitySN["cip"],
        address:'',
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
    if(this.userInfo.userName&&this.userInfo.password){
     // this.submitForm('ruleForm')
    }
    this.getLocation();
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate(async valid => {
         if (!valid) return false;
          const { data: res } = await this.$http.post( 
            "/loginServer?rememberMe="+this.rememberMe,
            this.$qs.stringify(this.userInfo),
            {
              onDownloadProgress:function (progressEvent) {
                  // 对原生进度事件的处理
                  console.log(progressEvent)
                  console.log('已经加载：' + (progressEvent.loaded / progressEvent.total) * 100 +'%');
              },
            }
          );
        if (res.statue != 200) return this.$message.error(res.message);
        if(this.rememberMe){
            this.RememberMe();
        }
        window.localStorage.setItem('token',res.token)
        this.$router.push("/Home");
      });
    },
    RememberMe(){
     var date=new Date(new Date().getTime()+1000*60*60*24*7)
      document.cookie ='BLOGUSERNAME='+this.userInfo.userName+";expires="+date.toGMTString()+";path=";
      document.cookie ='BLOGPASSWORD='+this.userInfo.password+";expires="+date.toGMTString()+";path=";
    },
    getLocation() {
      var _this = this;
      var map = new AMap.Map("container", {
        resizeEnable: true
      });
      AMap.plugin("AMap.Geolocation", function() {
        var geolocation = new AMap.Geolocation({
          enableHighAccuracy: true, //是否使用高精度定位，默认:true
          timeout: 60000 ,
        });
        map.addControl(geolocation);
        geolocation.getCurrentPosition(function(status, result) {
          if (status == "complete") {
            _this.onComplete(result,_this);
          } else {
            _this.onError(result);
          }
        });
      });
    },
    onComplete(data,_this) {
      let lngat=(data.position.lng+','+data.position.lat).split(',')
      var geocoder = new AMap.Geocoder({ city: "010", radius: 1000});
      geocoder.getAddress(lngat, function(status, result) {
        if (status === "complete" && result.regeocode) {
          _this.userInfo.address=result.regeocode.formattedAddress;
        } else {
          _this.userInfo.address="根据经纬度查询地址失败"
        }
      });
    },
    onError(result) {
      console.log(result);
    }
  }
};
</script>

<style lang="less" scoped>
.loginConainer {
  background-image: url(../assets/img/login.jpg);
  background-repeat: no-repeat;
  background-size: 100% 100%; //不兼容ie8以下
  position: relative;
  .loginForm {
    position: absolute;
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
