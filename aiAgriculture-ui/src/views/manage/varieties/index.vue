<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="68px">
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
      <el-form-item label="种子公司" prop="seedCompany">
        <el-input
          v-model="queryParams.seedCompany"
          placeholder="请输入种子公司"
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
          v-hasPermi="['manage:varieties:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="Edit"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['manage:varieties:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="Delete"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['manage:varieties:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="Download"
          @click="handleExport"
          v-hasPermi="['manage:varieties:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="varietiesList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" type="index" width="50" align="center" prop="id" />
      <el-table-column label="品种编号" align="center" prop="varietyCode" />
      <el-table-column label="品种名称" align="center" prop="varietyName" />
      <el-table-column label="种子公司" align="center" prop="seedCompany" />
      <el-table-column label="生产时间" align="center" prop="productionTime" />
      <el-table-column label="种子单价" align="center" prop="seedPrice" />
      <el-table-column label="价格单位" align="center" prop="priceUnit" />
      <el-table-column label="品种说明" align="center" prop="varietyDescription" show-overflow-tooltip/>
      <el-table-column label="备注" align="center" prop="remark" show-overflow-tooltip/>
      <el-table-column label="更新时间" align="center" prop="updatedAt" width="180">
        <template #default="scope">
          <span>{{ parseTime(scope.row.updatedAt, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <!-- <el-table-column label="更新人" align="center" prop="updatedBy" /> -->
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template #default="scope">
          <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['manage:varieties:edit']">修改</el-button>
          <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['manage:varieties:remove']">删除</el-button>
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

    <!-- 添加或修改品种管理对话框 -->
    <el-dialog :title="title" v-model="open" width="500px" append-to-body>
      <el-form ref="varietiesRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="品种编号" prop="varietyCode">
          <el-input v-model="form.varietyCode" placeholder="请输入品种编号" />
        </el-form-item>
        <el-form-item label="品种名称" prop="varietyName">
          <el-input v-model="form.varietyName" placeholder="请输入品种名称" />
        </el-form-item>
        <el-form-item label="种子公司" prop="seedCompany">
          <el-input v-model="form.seedCompany" placeholder="请输入种子公司" />
        </el-form-item>
        <el-form-item label="生产时间" prop="productionTime">
          <el-input v-model="form.productionTime" placeholder="请输入生产时间" />
        </el-form-item>
        <el-form-item label="种子单价" prop="seedPrice">
          <el-input v-model="form.seedPrice" placeholder="请输入种子单价" />
        </el-form-item>
        <el-form-item label="价格单位" prop="priceUnit">
          <el-input v-model="form.priceUnit" placeholder="请输入价格单位" />
        </el-form-item>
        <el-form-item label="品种说明" prop="varietyDescription">
          <el-input v-model="form.varietyDescription" type="textarea" placeholder="请输入内容" />
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

<script setup name="Varieties">
import { listVarieties, getVarieties, delVarieties, addVarieties, updateVarieties } from "@/api/manage/varieties";

const { proxy } = getCurrentInstance();

const varietiesList = ref([]);
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
    varietyCode: null,
    varietyName: null,
    seedCompany: null,
  },
  rules: {
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询品种管理列表 */
function getList() {
  loading.value = true;
  listVarieties(queryParams.value).then(response => {
    varietiesList.value = response.rows;
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
    varietyCode: null,
    varietyName: null,
    seedCompany: null,
    productionTime: null,
    seedPrice: null,
    priceUnit: null,
    varietyDescription: null,
    remark: null,
    createdAt: null,
    createdBy: null,
    updatedAt: null,
    updatedBy: null
  };
  proxy.resetForm("varietiesRef");
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
  title.value = "添加品种管理";
}

/** 修改按钮操作 */
function handleUpdate(row) {
  reset();
  const _id = row.id || ids.value
  getVarieties(_id).then(response => {
    form.value = response.data;
    open.value = true;
    title.value = "修改品种管理";
  });
}

/** 提交按钮 */
function submitForm() {
  proxy.$refs["varietiesRef"].validate(valid => {
    if (valid) {
      if (form.value.id != null) {
        updateVarieties(form.value).then(response => {
          proxy.$modal.msgSuccess("修改成功");
          open.value = false;
          getList();
        });
      } else {
        addVarieties(form.value).then(response => {
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
  proxy.$modal.confirm('是否确认删除品种管理编号为"' + _ids + '"的数据项？').then(function() {
    return delVarieties(_ids);
  }).then(() => {
    getList();
    proxy.$modal.msgSuccess("删除成功");
  }).catch(() => {});
}

/** 导出按钮操作 */
function handleExport() {
  proxy.download('manage/varieties/export', {
    ...queryParams.value
  }, `varieties_${new Date().getTime()}.xlsx`)
}

getList();
</script>
