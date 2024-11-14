<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="设备组编号" prop="groupCode">
        <el-input
          v-model="queryParams.groupCode"
          placeholder="请输入设备组编号"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="设备组名称" prop="groupName">
        <el-input
          v-model="queryParams.groupName"
          placeholder="请输入设备组名称"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="设备编号" prop="equipmentCode">
        <el-input
          v-model="queryParams.equipmentCode"
          placeholder="请输入设备编号"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="Search" @click="handleQuery">搜索</el-button>
        <el-button icon="Refresh" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="Plus"
          @click="handleAdd"
          v-hasPermi="['manage:eqpgroup:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="Edit"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['manage:eqpgroup:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="Delete"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['manage:eqpgroup:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="Download"
          @click="handleExport"
          v-hasPermi="['manage:eqpgroup:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="eqpgroupList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="自增主键" align="center" prop="id" />
      <el-table-column label="设备组编号" align="center" prop="groupCode" />
      <el-table-column label="设备组名称" align="center" prop="groupName" />
      <el-table-column label="设备编号" align="center" prop="equipmentCode" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template #default="scope">
          <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['manage:eqpgroup:edit']">修改</el-button>
          <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['manage:eqpgroup:remove']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      v-model:page="queryParams.pageNum"
      v-model:limit="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改设备组管理对话框 -->
    <el-dialog :title="title" v-model="open" width="500px" append-to-body>
      <el-form ref="eqpgroupRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="设备组编号" prop="groupCode">
          <el-input v-model="form.groupCode" placeholder="请输入设备组编号" />
        </el-form-item>
        <el-form-item label="设备组名称" prop="groupName">
          <el-input v-model="form.groupName" placeholder="请输入设备组名称" />
        </el-form-item>
        <el-form-item label="设备编号" prop="equipmentCode" v-if="form.id ">
          <el-input v-model="form.equipmentCode" placeholder="请输入设备编号" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-divider content-position="center">设备管理信息</el-divider>
        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
            <el-button type="primary" icon="Plus" @click="handleAddAgrEquipmentManagement">添加</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" icon="Delete" @click="handleDeleteAgrEquipmentManagement">删除</el-button>
          </el-col>
        </el-row>
        <el-table :data="agrEquipmentManagementList" :row-class-name="rowAgrEquipmentManagementIndex" @selection-change="handleAgrEquipmentManagementSelectionChange" ref="agrEquipmentManagement">
          <el-table-column type="selection" width="50" align="center" />
          <el-table-column label="序号" align="center" prop="index" width="50"/>
          <el-table-column label="设备名称" prop="equipmentName" width="150">
            <template #default="scope">
              <el-input v-model="scope.row.equipmentName" placeholder="请输入设备名称" />
            </template>
          </el-table-column>
          <el-table-column label="设备型号" prop="equipmentModel" width="150">
            <template #default="scope">
              <el-input v-model="scope.row.equipmentModel" placeholder="请输入设备型号" />
            </template>
          </el-table-column>
          <el-table-column label="设备用途" prop="equipmentPurpose" width="150">
            <template #default="scope">
              <el-input v-model="scope.row.equipmentPurpose" placeholder="请输入设备用途" />
            </template>
          </el-table-column>
          <el-table-column label="设备价格" prop="equipmentPrice" width="150">
            <template #default="scope">
              <el-input v-model="scope.row.equipmentPrice" placeholder="请输入设备价格" />
            </template>
          </el-table-column>
          <el-table-column label="生产公司" prop="equipmentCompany" width="150">
            <template #default="scope">
              <el-input v-model="scope.row.equipmentCompany" placeholder="请输入生产公司" />
            </template>
          </el-table-column>
          <el-table-column label="当前状态" prop="equipmentStatus" width="150">
            <template #default="scope">
              <el-select v-model="scope.row.equipmentStatus" placeholder="请选择当前状态">
                <el-option label="请选择字典生成" value="" />
              </el-select>
            </template>
          </el-table-column>
          <el-table-column label="更新时间" prop="updatedAt" width="240">
            <template #default="scope">
              <el-date-picker clearable
                v-model="scope.row.updatedAt"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择更新时间">
              </el-date-picker>
            </template>
          </el-table-column>
          <el-table-column label="更新人" prop="updatedBy" width="150">
            <template #default="scope">
              <el-input v-model="scope.row.updatedBy" placeholder="请输入更新人" />
            </template>
          </el-table-column>
        </el-table>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>

<script setup name="Eqpgroup">
import { listEqpgroup, getEqpgroup, delEqpgroup, addEqpgroup, updateEqpgroup } from "@/api/manage/eqpgroup";

const { proxy } = getCurrentInstance();

const eqpgroupList = ref([]);
const agrEquipmentManagementList = ref([]);
const open = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref([]);
const checkedAgrEquipmentManagement = ref([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const title = ref("");

const data = reactive({
  form: {},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    groupCode: null,
    groupName: null,
    equipmentCode: null,
  },
  rules: {
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询设备组管理列表 */
function getList() {
  loading.value = true;
  listEqpgroup(queryParams.value).then(response => {
    eqpgroupList.value = response.rows;
    total.value = response.total;
    loading.value = false;
  });
}

// 取消按钮
function cancel() {
  open.value = false;
  reset();
}

// 表单重置
function reset() {
  form.value = {
    id: null,
    groupCode: null,
    groupName: null,
    equipmentCode: null,
    remark: null
  };
  agrEquipmentManagementList.value = [];
  proxy.resetForm("eqpgroupRef");
}

/** 搜索按钮操作 */
function handleQuery() {
  queryParams.value.pageNum = 1;
  getList();
}

/** 重置按钮操作 */
function resetQuery() {
  proxy.resetForm("queryRef");
  handleQuery();
}

// 多选框选中数据
function handleSelectionChange(selection) {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
function handleAdd() {
  reset();
  open.value = true;
  title.value = "添加设备组管理";
}

/** 修改按钮操作 */
function handleUpdate(row) {
  reset();
  const _id = row.id || ids.value
  getEqpgroup(_id).then(response => {
    form.value = response.data;
    agrEquipmentManagementList.value = response.data.agrEquipmentManagementList;
    open.value = true;
    title.value = "修改设备组管理";
  });
}

/** 提交按钮 */
function submitForm() {
  proxy.$refs["eqpgroupRef"].validate(valid => {
    if (valid) {
      form.value.agrEquipmentManagementList = agrEquipmentManagementList.value;
      if (form.value.id != null) {
        updateEqpgroup(form.value).then(response => {
          proxy.$modal.msgSuccess("修改成功");
          open.value = false;
          getList();
        });
      } else {
        addEqpgroup(form.value).then(response => {
          proxy.$modal.msgSuccess("新增成功");
          open.value = false;
          getList();
        });
      }
    }
  });
}

/** 删除按钮操作 */
function handleDelete(row) {
  const _ids = row.id || ids.value;
  proxy.$modal.confirm('是否确认删除设备组管理编号为"' + _ids + '"的数据项？').then(function() {
    return delEqpgroup(_ids);
  }).then(() => {
    getList();
    proxy.$modal.msgSuccess("删除成功");
  }).catch(() => {});
}

/** 设备管理序号 */
function rowAgrEquipmentManagementIndex({ row, rowIndex }) {
  row.index = rowIndex + 1;
}

/** 设备管理添加按钮操作 */
function handleAddAgrEquipmentManagement() {
  let obj = {};
  obj.equipmentName = "";
  obj.equipmentModel = "";
  obj.equipmentPurpose = "";
  obj.equipmentPrice = "";
  obj.equipmentCompany = "";
  obj.equipmentStatus = "";
  obj.remark = "";
  obj.updatedAt = "";
  obj.updatedBy = "";
  agrEquipmentManagementList.value.push(obj);
}

/** 设备管理删除按钮操作 */
function handleDeleteAgrEquipmentManagement() {
  if (checkedAgrEquipmentManagement.value.length == 0) {
    proxy.$modal.msgError("请先选择要删除的设备管理数据");
  } else {
    const agrEquipmentManagements = agrEquipmentManagementList.value;
    const checkedAgrEquipmentManagements = checkedAgrEquipmentManagement.value;
    agrEquipmentManagementList.value = agrEquipmentManagements.filter(function(item) {
      return checkedAgrEquipmentManagements.indexOf(item.index) == -1
    });
  }
}

/** 复选框选中数据 */
function handleAgrEquipmentManagementSelectionChange(selection) {
  checkedAgrEquipmentManagement.value = selection.map(item => item.index)
}

/** 导出按钮操作 */
function handleExport() {
  proxy.download('manage/eqpgroup/export', {
    ...queryParams.value
  }, `eqpgroup_${new Date().getTime()}.xlsx`)
}

getList();
</script>
