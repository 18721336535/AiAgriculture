<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="种植编号" prop="plantingCode">
        <el-input
          v-model="queryParams.plantingCode"
          placeholder="请输入种植编号"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="品种编号" prop="varietyCode">
        <el-input
          v-model="queryParams.varietyCode"
          placeholder="请输入品种编号"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="品种名称" prop="varietyName">
        <el-input
          v-model="queryParams.varietyName"
          placeholder="请输入品种名称"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="地块编号" prop="plotCode">
        <el-input
          v-model="queryParams.plotCode"
          placeholder="请输入地块编号"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="地块名" prop="plotName">
        <el-input
          v-model="queryParams.plotName"
          placeholder="请输入地块名"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="设备组" prop="groupCode">
        <el-input
          v-model="queryParams.groupCode"
          placeholder="请输入设备组"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="管理员" prop="managerCode">
        <el-input
          v-model="queryParams.managerCode"
          placeholder="请输入管理员"
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
          v-hasPermi="['manage:planting:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="Edit"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['manage:planting:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="Delete"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['manage:planting:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="Download"
          @click="handleExport"
          v-hasPermi="['manage:planting:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="plantingList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="自增主键" align="center" prop="id" />
      <el-table-column label="种植编号" align="center" prop="plantingCode" />
      <el-table-column label="品种编号" align="center" prop="varietyCode" />
      <el-table-column label="品种名称" align="center" prop="varietyName" />
      <el-table-column label="地块编号" align="center" prop="plotCode" />
      <el-table-column label="地块名" align="center" prop="plotName" show-overflow-tooltip/>
      <el-table-column label="地块面积" align="center" prop="plotArea" />
      <el-table-column label="设备组" align="center" prop="groupCode" />
      <el-table-column label="管理员" align="center" prop="managerCode" />
      <el-table-column label="当前状态" align="center" prop="currentStatus" />
      <el-table-column label="产量kg" align="center" prop="productionAmount" />
      <el-table-column label="更新人" align="center" prop="updatedBy" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template #default="scope">
          <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['manage:planting:edit']">修改</el-button>
          <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['manage:planting:remove']">删除</el-button>
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

    <!-- 添加或修改种植管理对话框 -->
    <el-dialog :title="title" v-model="open" width="500px" append-to-body>
      <el-form ref="plantingRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="种植编号" prop="plantingCode">
          <el-input v-model="form.plantingCode" placeholder="请输入种植编号" />
        </el-form-item>
        <el-form-item label="品种编号" prop="varietyCode">
          <el-input v-model="form.varietyCode" placeholder="请输入品种编号" />
        </el-form-item>
        <el-form-item label="品种名称" prop="varietyName">
          <el-input v-model="form.varietyName" placeholder="请输入品种名称" />
        </el-form-item>
        <el-form-item label="地块编号" prop="plotCode">
          <el-input v-model="form.plotCode" placeholder="请输入地块编号" />
        </el-form-item>
        <el-form-item label="地块名" prop="plotName">
          <el-input v-model="form.plotName" placeholder="请输入地块名" />
        </el-form-item>
        <el-form-item label="地块面积" prop="plotArea">
          <el-input v-model="form.plotArea" placeholder="请输入地块面积" />
        </el-form-item>
        <el-form-item label="设备组" prop="groupCode">
          <el-input v-model="form.groupCode" placeholder="请输入设备组" />
        </el-form-item>
        <el-form-item label="管理员" prop="managerCode">
          <el-input v-model="form.managerCode" placeholder="请输入管理员" />
        </el-form-item>
        <el-form-item label="产量kg" prop="productionAmount">
          <el-input v-model="form.productionAmount" placeholder="请输入产量kg" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="更新人" prop="updatedBy">
          <el-input v-model="form.updatedBy" placeholder="请输入更新人" />
        </el-form-item>
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

<script setup name="Planting">
import { listPlanting, getPlanting, delPlanting, addPlanting, updatePlanting } from "@/api/manage/planting";

const { proxy } = getCurrentInstance();

const plantingList = ref([]);
const open = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const title = ref("");

const data = reactive({
  form: {},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    plantingCode: null,
    varietyCode: null,
    varietyName: null,
    plotCode: null,
    plotName: null,
    groupCode: null,
    managerCode: null,
  },
  rules: {
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询种植管理列表 */
function getList() {
  loading.value = true;
  listPlanting(queryParams.value).then(response => {
    plantingList.value = response.rows;
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
    plantingCode: null,
    varietyCode: null,
    varietyName: null,
    plotCode: null,
    plotName: null,
    plotArea: null,
    groupCode: null,
    managerCode: null,
    currentStatus: null,
    productionAmount: null,
    remark: null,
    createdAt: null,
    createdBy: null,
    updatedAt: null,
    updatedBy: null
  };
  proxy.resetForm("plantingRef");
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
  title.value = "添加种植管理";
}

/** 修改按钮操作 */
function handleUpdate(row) {
  reset();
  const _id = row.id || ids.value
  getPlanting(_id).then(response => {
    form.value = response.data;
    open.value = true;
    title.value = "修改种植管理";
  });
}

/** 提交按钮 */
function submitForm() {
  proxy.$refs["plantingRef"].validate(valid => {
    if (valid) {
      if (form.value.id != null) {
        updatePlanting(form.value).then(response => {
          proxy.$modal.msgSuccess("修改成功");
          open.value = false;
          getList();
        });
      } else {
        addPlanting(form.value).then(response => {
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
  proxy.$modal.confirm('是否确认删除种植管理编号为"' + _ids + '"的数据项？').then(function() {
    return delPlanting(_ids);
  }).then(() => {
    getList();
    proxy.$modal.msgSuccess("删除成功");
  }).catch(() => {});
}

/** 导出按钮操作 */
function handleExport() {
  proxy.download('manage/planting/export', {
    ...queryParams.value
  }, `planting_${new Date().getTime()}.xlsx`)
}

getList();
</script>
