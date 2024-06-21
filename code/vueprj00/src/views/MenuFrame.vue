<template>
  <div>
    <el-tabs v-model="activeName" @tab-click="handleClick">
      <el-tab-pane label="普通用户管理" name="first">
        <el-tabs v-model="activeName2" @tab-click="handleClick" tab-position="left">

          <el-tab-pane label="用户账号管理" name="first">
            <el-button @click="getUserList()" id="loginButton" type="primary" round>
              数据浏览
            </el-button>
            <el-button @click="getUserById()" id="Button1" type="primary" round>
              根据ID查询
            </el-button>

            <el-button @click="getUserByName()" id="Button3" type="primary" round>
              根据名字查询
            </el-button>
            <el-table :data="tableData" style="width: 100%">

              <el-table-column label="id" width="200">
                <template slot-scope="scope">

                  <span style="margin-left: 10px">{{ scope.row.id }}</span>
                </template>
              </el-table-column>
              <el-table-column label="姓名" width="200">
                <template slot-scope="scope">

                  <span style="margin-left: 10px">{{ scope.row.name }}</span>
                </template>
              </el-table-column>

              <el-table-column label="性别" width="200">
                <template slot-scope="scope">

                  <span style="margin-left: 10px">{{ scope.row.gender }}</span>
                </template>
              </el-table-column>

              <el-table-column label="年龄" width="200">
                <template slot-scope="scope">

                  <span style="margin-left: 10px">{{ scope.row.age }}</span>
                </template>
              </el-table-column>

              <el-table-column label="操作">
                <template slot-scope="scope">
                  <el-button size="mini" :disabled="disabled03"
                    @click="handleEditName(scope.$index, scope.row)">编辑姓名</el-button>
                  <el-button size="mini" :disabled="disabled03"
                    @click="handleEditGender(scope.$index, scope.row)">编辑性别</el-button>
                  <el-button size="mini" :disabled="disabled03"
                    @click="handleEditAge(scope.$index, scope.row)">编辑年龄</el-button>
                  <el-button size="mini" :disabled="disabled03" type="danger"
                    @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                </template>
              </el-table-column>
            </el-table>
          </el-tab-pane>

          <el-tab-pane label="账号添加" name="second" :disabled="disabled01">
            <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px"
              class="demo-ruleForm">
              <el-form-item label="id" prop="id">
                <el-input style="width:250px" type="id" v-model="ruleForm.id" autocomplete="off"></el-input>
              </el-form-item>

              <el-form-item label="姓名" prop="name">
                <el-input style="width: 150px" type="S" v-model="ruleForm.name" autocomplete="off"></el-input>
              </el-form-item>

              <el-form-item label="性别" prop="gender">
                <el-input style="width: 100px" v-model.number="ruleForm.gender"></el-input>
              </el-form-item>

              <el-form-item label="年龄" prop="age">
                <el-input style="width: 100px" v-model.number="ruleForm.age"></el-input>
              </el-form-item>


              <el-form-item label="权限" prop="privilege">
                <el-input style="width: 100px" v-model.number="ruleForm.privilege"></el-input>
              </el-form-item>


              <el-form-item>
                <el-button type="primary" @click="insert()">提交</el-button>
                <el-button @click="resetForm('ruleForm')">重置</el-button>
              </el-form-item>
            </el-form>

          </el-tab-pane>
        </el-tabs>
      </el-tab-pane>




      <el-tab-pane label="权限用户管理" name="third" :disabled="disabled02">
        <el-tabs v-model="activeName3" @tab-click="handleClick" tab-position="left">
          <el-tab-pane label="权限账号管理" name="forth">
            <el-button @click="getActList()" id="loginButton" type="primary" round>
              数据浏览
            </el-button>
            <el-button @click="getActByAct()" id="Button1" type="primary" round>
              根据账号查询
            </el-button>

            <el-button @click="getActByName()" id="Button3" type="primary" round>
              根据名字查询
            </el-button>
            <el-table :data="tableData" style="width: 100%">

              <el-table-column label="账号" width="200">
                <template slot-scope="scope">

                  <span style="margin-left: 10px">{{ scope.row.act }}</span>
                </template>
              </el-table-column>
              <el-table-column label="姓名" width="200">
                <template slot-scope="scope">

                  <span style="margin-left: 10px">{{ scope.row.name }}</span>
                </template>
              </el-table-column>

              <el-table-column label="密码" width="200">
                <template slot-scope="scope">

                  <span style="margin-left: 10px">{{ scope.row.password }}</span>
                </template>
              </el-table-column>


              <el-table-column label="权限等级" width="200">
                <template slot-scope="scope">

                  <span style="margin-left: 10px">{{ scope.row.privilege }}</span>
                </template>
              </el-table-column>

              <el-table-column label="操作">
                <template slot-scope="scope">

                  <el-button size="mini" @click="handleEditName1(scope.$index, scope.row)">编辑姓名</el-button>
                  <el-button size="mini" @click="handleEditPassword1(scope.$index, scope.row)">编辑密码</el-button>
                  <el-button size="mini" @click="handleEditPrivilege1(scope.$index, scope.row)">编辑权限</el-button>
                  <el-button size="mini" type="danger" @click="handleDelete1(scope.$index, scope.row)">删除</el-button>

                </template>
              </el-table-column>

            </el-table>



          </el-tab-pane>
          <el-tab-pane label="账号添加" name="fifth">
            <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px"
              class="demo-ruleForm">
              <el-form-item label="Act" prop="act">
                <el-input style="width:250px" type="act" v-model="ruleForm1.act" autocomplete="off"></el-input>
              </el-form-item>

              <el-form-item label="姓名" prop="name1">
                <el-input style="width: 150px" type="name1" v-model="ruleForm1.name1" autocomplete="off"></el-input>
              </el-form-item>

              <el-form-item label="密码" prop="password">
                <el-input style="width: 100px" v-model.number="ruleForm1.password"></el-input>
              </el-form-item>


              <el-form-item label="权限" prop="privilege1">
                <el-input style="width: 100px" v-model.number="ruleForm1.privilege1"></el-input>
              </el-form-item>




              <el-form-item>
                <el-button type="primary" @click="actInsert()">提交</el-button>
                <el-button @click="resetForm('ruleForm')">重置</el-button>
              </el-form-item>
            </el-form>


          </el-tab-pane>
        </el-tabs>

      </el-tab-pane>


    </el-tabs>


  </div>
</template>

<script>


export default {
  name: "MenuFrame",
  activeName: 'first',
  activeName2: 'second',
  activeName3: 'third',
  activeName4: 'forth',
  activeName5: 'fifth',


  data() {

    var checkUserNumber = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('账号不能为空'));
      }

    };
    var checkName = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('姓名不能为空'));
      }

    };
    var checkPrivilege = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('权限不能为空'));
      }

    };


    return {
      disabled01: true,
      disabled02: true,
      disabled03: true,
      ruleForm: {
        id: '',
        name: '',
        gender: '',
        age: '',
        privilege: '',
      },
      ruleForm1: {
        act: '',
        name1: '',
        passowrd: '',
        privilege1: '',
      },





      rules: {
        privilege: [
          { validator: checkPrivilege, trigger: 'blur' }
        ],

        userNumber: [
          { validator: checkUserNumber, trigger: 'blur' }
        ],

        name: [
          { validator: checkName, trigger: 'blur' }
        ],


      },
      tableData: [{

      }]

    }
  },

  created() {
    this.load();
  },

  methods: {
    handleEditGender(index, row) {

      this.$prompt('请输入修改内容', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
      }).then(({ value }) => {
        this.$message({
          type: 'success',
          message: '你修改的结果是: ' + value
        });

        var id0 = (index, row).id;
        var name0 = (index, row).name;
        var age0 = (index, row).age;
        var gender0 = value;
        var privilege0 = (index, row).privilege;

        this.$axios.get('/api/userUpdate', {

          params: {
            id: id0,
            name: name0,
            age: age0,
            gender: gender0,
            privilege: privilege0,
          }
        });

      }).catch(() => {
        this.$message({
          type: 'info',
          message: '取消输入'
        });

      });

    },

    handleEditAge(index, row) {

      this.$prompt('请输入修改内容', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
      }).then(({ value }) => {
        this.$message({
          type: 'success',
          message: '你修改的结果是: ' + value
        });

        var id0 = (index, row).id;
        var name0 = (index, row).name;
        var age0 = value;
        var gender0 = (index, row).gender;
        var privilege0 = (index, row).privilege;

        this.$axios.get('/api/userUpdate', {

          params: {
            id: id0,
            name: name0,
            age: age0,
            gender: gender0,
            privilege: privilege0,
          }
        });




      }).catch(() => {
        this.$message({
          type: 'info',
          message: '取消输入'
        });

      });

    },
    handleEditName(index, row) {

      this.$prompt('请输入修改内容', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
      }).then(({ value }) => {
        this.$message({
          type: 'success',
          message: '你修改的结果是: ' + value
        });
        var id0 = (index, row).id;
        var name0 = value;
        var age0 = (index, row).age;
        var gender0 = (index, row).gender;
        var privilege0 = (index, row).privilege;


        this.$axios.get('/api/userUpdate', {

          params: {
            id: id0,
            name: name0,
            age: age0,
            gender: gender0,
            privilege: privilege0,
          }
        });




      }).catch(() => {
        this.$message({
          type: 'info',
          message: '取消输入'
        });

      });

    },

    handleEditPrivilege1(index, row) {

      this.$prompt('请输入修改内容', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
      }).then(({ value }) => {
        this.$message({
          type: 'success',
          message: '你修改的结果是: ' + value
        });

        var act0 = (index, row).act;
        var name0 = (index, row).name;
        var password0 = (index, row).password;
        var privilege0 = value;

        this.$axios.get('/api/actUpdate', {

          params: {
            act: act0,
            name: name0,
            password: password0,
            privilege: privilege0,
          }
        });

      }).catch(() => {
        this.$message({
          type: 'info',
          message: '取消输入'
        });

      });

    },

    handleEditPassword1(index, row) {

      this.$prompt('请输入修改内容', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
      }).then(({ value }) => {
        this.$message({
          type: 'success',
          message: '你修改的结果是: ' + value
        });

        var act0 = (index, row).act;
        var name0 = (index, row).name;
        var password0 = value;
        var privilege0 = (index, row).privilege;

        this.$axios.get('/api/actUpdate', {

          params: {
            act: act0,
            name: name0,
            password: password0,
            privilege: privilege0,
          }
        });




      }).catch(() => {
        this.$message({
          type: 'info',
          message: '取消输入'
        });

      });

    },
    handleEditName1(index, row) {

      this.$prompt('请输入修改内容', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
      }).then(({ value }) => {
        this.$message({
          type: 'success',
          message: '你修改的结果是: ' + value
        });

        var act0 = (index, row).act;
        var name0 = value;
        var password0 = (index, row).password;
        var privilege0 = (index, row).privilege;

        this.$axios.get('/api/actUpdate', {

          params: {
            act: act0,
            name: name0,
            password: password0,
            privilege: privilege0,
          }
        });




      }).catch(() => {
        this.$message({
          type: 'info',
          message: '取消输入'
        });

      });

    },
    handleCommand(command) {
      this.$message('click on item ' + command);
    },


    handleEdit(index, row) {
      console.log(index, row);
    },

    load() {


      if (this.$route.query.privilege && this.$route.query.privilege != 1) {
        this.disabled01 = false;
        this.disabled02 = false;
        this.disabled03 = false;
      }

    },

    actInsert() {
      this.$axios.get('/api/actInsert', {
        params: {
          act: this.ruleForm1.act,
          name: this.ruleForm1.name1,
          password: this.ruleForm1.password,
          privilege: this.ruleForm1.privilege1,
        }
      }).then(res => {
        console.log(res.data);
        if (res.data === 0)
          this.$message({
            type: 'error',
            message: '添加失败!'
          });
        else {
          this.$message({
            type: 'success',
            message: '添加成功!'
          });
        }

      })

    },

    insert() {
      this.$axios.get('/api/insert', {
        params: {
          id: this.ruleForm.id,
          name: this.ruleForm.name,
          gender: this.ruleForm.gender,
          age: this.ruleForm.age,
          privilege: this.ruleForm.privilege,
        }
      }).then(res => {
        console.log(res.data);
        if (res.data === 0)
          this.$message({
            type: 'error',
            message: '添加失败!'
          });
        else {
          this.$message({
            type: 'success',
            message: '添加成功!'
          });
        }

      })

    },


    getActByAct() {
      this.$prompt('请输入需要查询的Act', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
      }).then(({ value }) => {
        this.$message({
          type: 'success',
          message: '查询操作成功!'
        });
        var act = value;
        this.$axios.get("/api/getActById?act=" + act).then(res => {
          if (res.data.length === 0) {
            this.$message({
              type: 'error',
              message: '账号不存在！！ '
            });
          }
          else this.tableData = res.data;




        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '取消输入'
        });

      });

    },

    getUserById() {
      this.$prompt('请输入需要查询的Id', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
      }).then(({ value }) => {
        this.$message({
          type: 'success',
          message: '查询操作成功!'
        });
        var id = value;
        this.$axios.get("/api/getUserById?id=" + id).then(res => {
          if (res.data.length === 0) {
            this.$message({
              type: 'error',
              message: '账号不存在！！ '
            });
          }
          else this.tableData = res.data;




        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '取消输入'
        });

      });

    },
    getActList() {
      this.$axios.get("/api/getActList").then(res => {
        this.tableData = res.data;
      })
    },

    getUserList() {
      this.$axios.get("/api/getUserList").then(res => {
        this.tableData = res.data;
      })

    },





    getActByName() {
      this.$prompt('请输入需要查询的姓名', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
      }).then(({ value }) => {
        this.$message({
          type: 'success',
          message: '查询操作成功!'
        });
        var name = value;
        this.$axios.get("/api/getActByName?name=" + name).then(res => {
          if (res.data.length === 0) {
            this.$message({
              type: 'error',
              message: '账号不存在！！ '
            });
          }
          else this.tableData = res.data;




        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '取消输入'
        });

      });

    },




    getUserByName() {
      this.$prompt('请输入需要查询的姓名', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
      }).then(({ value }) => {
        this.$message({
          type: 'success',
          message: '查询操作成功!'
        });
        var name = value;
        this.$axios.get("/api/getUserByName?name=" + name).then(res => {
          if (res.data.length === 0) {
            this.$message({
              type: 'error',
              message: '账号不存在！！ '
            });
          }
          else this.tableData = res.data;




        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '取消输入'
        });

      });

    },



    handleDelete(index, row) {
      var id = ((index, row).id);
      this.$axios.get("/api/deleteById?id=" + id).then(res => {
        this.$message({
          type: 'success',
          message: '删除成功！！ '
        });

      });
    },
    handleDelete1(index, row) {
      var act = ((index, row).act);
      this.$axios.get("/api/actDeleteById?act=" + act).then(res => {
        this.$message({
          type: 'success',
          message: '删除成功！！ '
        });

      });
    }
  }
}


</script>

<style scoped>
.el-dropdown-link {
  cursor: pointer;
  color: #409EFF;
}

.el-icon-arrow-down {
  font-size: 12px;
}
</style>
