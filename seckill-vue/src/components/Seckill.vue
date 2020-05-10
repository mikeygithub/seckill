<template>
    <div>
        <el-row :gutter="24">
            <el-col :span="24">
                <h1 class="bg-purple-dark" style="border-radius: 8px">DESIGN AND IMPLEMENTATION OF SECKILL SYSTEM</h1>
            </el-col>
        </el-row>
        <el-row :gutter="24">
            <el-col :span="12">
                <div><h1 class="bg-purple" style="border-radius: 8px">SECKILL</h1></div>
                <div class="grid-content bg-purple">
                    <el-table
                            :data="tableData"
                            style="width: 100%">
                        <el-table-column
                                width="80"
                                label="index"
                                type="index">
                        </el-table-column>
                        <el-table-column
                                label="SecKillTime"
                                width="180">
                            <template slot-scope="scope">
                                <i class="el-icon-time"></i>
                                <span style="margin-left: 10px">{{ scope.row.date }}</span>
                            </template>
                        </el-table-column>
                        <el-table-column
                                label="GoodName"
                                width="180">
                            <template slot-scope="scope">
                                <el-popover trigger="hover" placement="top">
                                    <p>姓名: {{ scope.row.name }}</p>
                                    <p>住址: {{ scope.row.address }}</p>
                                    <div slot="reference" class="name-wrapper">
                                        <el-tag size="medium">{{ scope.row.name }}</el-tag>
                                    </div>
                                </el-popover>
                            </template>
                        </el-table-column>
                        <el-table-column
                            label="Price">
                        </el-table-column>
                        <el-table-column
                                label="Number">
                        </el-table-column>
                        <el-table-column label="Operation">
                            <template slot-scope="scope">
                                <el-button
                                        size="mini"
                                        @click="handleEdit(scope.$index, scope.row)">编辑
                                </el-button>
                                <el-button
                                        size="mini"
                                        type="danger"
                                        @click="handleDelete(scope.$index, scope.row)">删除
                                </el-button>
                            </template>
                        </el-table-column>
                    </el-table>
                    <el-pagination
                            style="margin-top: 10px"
                            background
                            :hide-on-single-page="true"
                            layout="prev, pager, next"
                            :total="100">
                    </el-pagination>
                </div>
            </el-col>
            <el-col :span="12">
                <div><h1 class="bg-purple" style="border-radius: 8px">PUBLISH</h1></div>
                <div class="grid-content bg-purple">
                    <el-form :model="dataForm" label-width="110px" :rules="dataRule" ref="dataForm"
                             @keyup.enter.native="dataFormSubmit()" style="width: 330px;margin: 100px auto" status-icon>
                        <el-form-item label="GOODNAME" prop="goodName">
                            <el-input v-model="dataForm.goodName" placeholder="Good Name"></el-input>
                        </el-form-item>
                        <el-form-item label="GOODPRICE" prop="goodNumber">
                            <el-input v-model="dataForm.goodNumber" placeholder="Good Number"></el-input>
                        </el-form-item>
                        <el-form-item label="GOODPRICE" prop="goodPrice">
                            <el-input v-model="dataForm.goodPrice" placeholder="Good Price"></el-input>
                        </el-form-item>
                        <el-form-item label="SECKILLTIME" prop="secKillTime">
                            <div class="block">
                                <el-date-picker
                                        v-model="dataForm.secKillTime"
                                        type="datetime"
                                        placeholder="CHOICE SEC KILL TIME">
                                </el-date-picker>
                            </div>
                        </el-form-item>
                        <el-form-item>
                            <el-button class="login-btn-submit" type="primary" @click="publishHandle()"
                                       :loading="loginLoading">PUBLISH
                            </el-button>
                        </el-form-item>
                    </el-form>
                </div>
            </el-col>
        </el-row>
    </div>
</template>

<script>
    export default {
        name: "Seckill",
        data() {
            return {
                dataForm: {
                    goodName: '',
                    goodNumber: '',
                    goodPrice: '',
                    secKillTime: '',
                },
                tableData: [{
                    date: '2016-05-02',
                    name: '王小虎',
                    address: '上海市普陀区金沙江路 1518 弄'
                }, {
                    date: '2016-05-04',
                    name: '王小虎',
                    address: '上海市普陀区金沙江路 1517 弄'
                }, {
                    date: '2016-05-01',
                    name: '王小虎',
                    address: '上海市普陀区金沙江路 1519 弄'
                }, {
                    date: '2016-05-03',
                    name: '王小虎',
                    address: '上海市普陀区金沙江路 1516 弄'
                },{
                    date: '2016-05-02',
                    name: '王小虎',
                    address: '上海市普陀区金沙江路 1518 弄'
                }, {
                    date: '2016-05-04',
                    name: '王小虎',
                    address: '上海市普陀区金沙江路 1517 弄'
                }, {
                    date: '2016-05-01',
                    name: '王小虎',
                    address: '上海市普陀区金沙江路 1519 弄'
                }, {
                    date: '2016-05-03',
                    name: '王小虎',
                    address: '上海市普陀区金沙江路 1516 弄'
                }, {
                    date: '2016-05-01',
                    name: '王小虎',
                    address: '上海市普陀区金沙江路 1519 弄'
                }, {
                    date: '2016-05-03',
                    name: '王小虎',
                    address: '上海市普陀区金沙江路 1516 弄'
                }],
                loginLoading: false,
                dataRule: {
                    goodName: [
                        {required: true, message: '名称不能为空', trigger: 'blur'}
                    ],
                    goodNumber: [
                        {required: true, message: '数量不能为空', trigger: 'blur'}
                    ],
                    goodPrice: [
                        {required: true, message: '单价不能为空', trigger: 'blur'}
                    ],
                    secKillTime: [
                        {required: true, message: '时间不能为空', trigger: 'blur'}
                    ]
                },
            }

        },
        methods: {
            init() {

            },
            publishHandle() {
                this.$refs['dataForm'].validate((valid) => {
                    if (valid) {
                        this.loginLoading = true
                        this.$http({
                            url: this.$http.adornSecKillUrl('seckill/publish'),
                            method: 'post',
                            data: this.$http.adornData({
                                'goodNumber':this.dataForm.goodNumber,
                                'goodPrice':this.dataForm.goodPrice,
                                'startTime':this.dataForm.secKillTime,
                            })
                        }).then(({data}) => {
                            this.loginLoading = false
                            if (data && data.code === 0) {
                                this.$notify({
                                    title: '系统提示',
                                    message: '操作成功',
                                    type: 'success'
                                })
                            } else {
                                this.$message.error(data.msg)
                            }
                        })
                        this.loginLoading = false
                    }
                })
            },
            handleEdit(index, row) {
                console.log(index, row);
            },
            handleDelete(index, row) {
                console.log(index, row);
            },
        }
    }
</script>

<style scoped>
    .el-row {
        margin-bottom: 20px;

    &
    :last-child {
        margin-bottom: 0;
    }

    }
    .el-col {
        border-radius: 4px;
    }

    .bg-purple-dark {
        background: #99a9bf;
    }

    .bg-purple {
        background: #d3dce6;
    }

    .bg-purple-light {
        background: #e5e9f2;
    }

    .grid-content {
        border-radius: 4px;
        padding: 30px;
        padding-bottom: 5px;
        min-height: 650px;
    }

    .row-bg {
        padding: 10px 0;
        background-color: #f9fafc;
    }
</style>