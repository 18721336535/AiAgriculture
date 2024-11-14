-- 删除已存在的表
DROP TABLE IF EXISTS `agr_crop_varieties`;

-- 创建品种表
CREATE TABLE `agr_crop_varieties` (
  `id` INT AUTO_INCREMENT PRIMARY KEY COMMENT '自增主键',
  `variety_code` VARCHAR(8) DEFAULT NULL COMMENT '品种编号',
  `variety_name` VARCHAR(255) DEFAULT NULL COMMENT '品种名称',
  `seed_company` VARCHAR(255) DEFAULT NULL COMMENT '种子公司',
  `production_time` VARCHAR(255) DEFAULT NULL COMMENT '生产时间',
  `seed_price` VARCHAR(255) DEFAULT NULL COMMENT '种子单价',
  `price_unit` VARCHAR(255) DEFAULT NULL COMMENT '价格单位',
  `variety_description` TEXT DEFAULT NULL COMMENT '品种说明',
  `remark` TEXT DEFAULT NULL COMMENT '备注',
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间（默认当前时间）',
  `created_by` VARCHAR(255) DEFAULT 'system' COMMENT '创建人（默认system）',
  `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间（默认当前时间）',
  `updated_by` VARCHAR(255) DEFAULT 'system' COMMENT '更新人（默认system）'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='作物品种表';

-- 插入测试数据
INSERT INTO `agr_crop_varieties` (`variety_code`, `variety_name`, `seed_company`, `production_time`, `seed_price`, `price_unit`, `variety_description`, `remark`) VALUES
-- 水稻品种
('V0000001', '南粳9108', '江苏农科院', '2022-05-15', '50.00', '元/公斤', '南粳9108是江苏省农业科学院粮食作物研究所选育的优质高产水稻新品种，具有抗病性强、适应性广等特点。', '适合在江苏、安徽等地种植。'),
('V0000002', '甬优1540', '宁波市农科院', '2021-07-20', '45.00', '元/公斤', '甬优1540是由宁波市农业科学研究院选育的优质高产水稻新品种，具有米质优良、产量高、抗逆性强等特点。', '适合在浙江、上海等地种植。'),
('V0000003', '丰两优香1号', '中国水稻研究所', '2020-09-10', '55.00', '元/公斤', '丰两优香1号是中国水稻研究所选育的优质高产水稻新品种，具有米质香软、产量高、抗病性强等特点。', '适合在湖南、湖北等地种植。'),
('V0000004', '沪稻19', '上海市农科院', '2019-06-25', '48.00', '元/公斤', '沪稻19是由上海市农业科学院选育的优质高产水稻新品种，具有米质好、产量高、抗病性强等特点。', '适合在上海、江苏等地种植。'),
('V0000005', '粤晶丝苗2号', '广东省农科院', '2023-03-12', '52.00', '元/公斤', '粤晶丝苗2号是由广东省农业科学院选育的优质高产水稻新品种，具有米质优良、产量高、抗逆性强等特点。', '适合在广东、广西等地种植。'),

-- 西瓜品种
('V0000006', '早春红玉', '北京农科院', '2022-04-10', '30.00', '元/公斤', '早春红玉是北京市农业科学院选育的早熟西瓜品种，果皮薄，甜度高，适合早春种植。', '适合在北方地区种植。'),
('V0000007', '黑美人', '山东农科院', '2021-05-15', '25.00', '元/公斤', '黑美人是山东省农业科学院选育的中熟西瓜品种，果皮黑色，肉质细嫩，甜度高。', '适合在山东、河南等地种植。'),
('V0000008', '金城5号', '甘肃农科院', '2020-06-20', '28.00', '元/公斤', '金城5号是甘肃省农业科学院选育的晚熟西瓜品种，果皮绿色，肉质鲜甜，耐贮运。', '适合在西北地区种植。'),

-- 蔬菜品种
('V0000009', '津绿5号', '天津农科院', '2022-03-20', '15.00', '元/公斤', '津绿5号是天津市农业科学院选育的黄瓜品种，生长势强，抗病性好，适合设施栽培。', '适合在北方设施大棚种植。'),
('V0000010', '绿宝', '河北农科院', '2021-04-15', '12.00', '元/公斤', '绿宝是河北省农业科学院选育的番茄品种，果实大，色泽鲜艳，口感好。', '适合在河北、山西等地种植。'),
('V0000011', '翠玉', '江苏农科院', '2020-05-10', '18.00', '元/公斤', '翠玉是江苏省农业科学院选育的辣椒品种，果实长，颜色鲜绿，辣味适中。', '适合在江苏、安徽等地种植。');

-- 删除已存在的表
DROP TABLE IF EXISTS `agr_plot_information`;

-- 创建地块信息表
CREATE TABLE `agr_plot` (
  `id` INT AUTO_INCREMENT PRIMARY KEY COMMENT '自增主键',
  `plot_code` VARCHAR(8) DEFAULT NULL COMMENT '地块编号',
  `plot_area` VARCHAR(255) DEFAULT NULL COMMENT '地块面积(m2)',
  `plot_name` VARCHAR(255) DEFAULT NULL COMMENT '地块名称',
  `plot_address` VARCHAR(255) DEFAULT NULL COMMENT '地块地址',
  `terrain` VARCHAR(255) DEFAULT NULL COMMENT '地形地势',
  `soil_type` VARCHAR(255) DEFAULT NULL COMMENT '土壤类型',
  `remark` TEXT DEFAULT NULL COMMENT '备注',
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间（默认当前时间）',
  `created_by` VARCHAR(255) DEFAULT 'system' COMMENT '创建人（默认system）',
  `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间（默认当前时间）',
  `updated_by` VARCHAR(255) DEFAULT 'system' COMMENT '更新人（默认system）'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='地块信息表';

-- 插入测试数据
INSERT INTO `agr_plot` (`plot_code`, `plot_area`, `plot_name`, `plot_address`, `terrain`, `soil_type`, `remark`) VALUES
('P0000001', '10000', '地块A', '上海市浦东新区陆家嘴小区', '平坦', '壤土', '适合种植水稻'),
('P0000002', '15000', '地块B', '江苏省南京市玄武区紫金山小区', '丘陵', '沙壤土', '适合种植小麦'),
('P0000003', '12000', '地块C', '浙江省杭州市西湖区龙井村小区', '山地', '黏土', '适合种植茶叶'),
('P0000004', '8000', '地块D', '广东省广州市天河区珠江新城小区', '平原', '砂土', '适合种植蔬菜'),
('P0000005', '18000', '地块E', '山东省青岛市崂山区崂山小区', '丘陵', '壤土', '适合种植苹果'),
('P0000006', '11000', '地块F', '河南省郑州市中原区二七广场小区', '平原', '黏壤土', '适合种植玉米'),
('P0000007', '9000', '地块G', '四川省成都市武侯区锦里小区', '盆地', '壤土', '适合种植水稻'),
('P0000008', '13000', '地块H', '湖南省长沙市岳麓区岳麓山小区', '山地', '砂壤土', '适合种植茶叶');

-- 删除已存在的表
DROP TABLE IF EXISTS `agr_crop_manager`;

-- 创建作物管理人员表
CREATE TABLE `agr_crop_manager` (
  `id` INT AUTO_INCREMENT PRIMARY KEY COMMENT '自增主键',
  `manager_code` VARCHAR(8) DEFAULT NULL COMMENT '管理员编号',
  `manager_name` VARCHAR(255) DEFAULT NULL COMMENT '管理员姓名',
  `job_type` VARCHAR(255) DEFAULT NULL COMMENT '工种类型',
  `email` VARCHAR(255) DEFAULT NULL COMMENT '邮箱',
  `contact_info` VARCHAR(255) DEFAULT NULL COMMENT '联系方式',
  `phone_number` VARCHAR(255) DEFAULT NULL COMMENT '联系电话',
  `remark` TEXT DEFAULT NULL COMMENT '备注',
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间（默认当前时间）',
  `created_by` VARCHAR(255) DEFAULT 'system' COMMENT '创建人（默认system）',
  `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间（默认当前时间）',
  `updated_by` VARCHAR(255) DEFAULT 'system' COMMENT '更新人（默认system）'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='作物管理人员表';

-- 插入测试数据
INSERT INTO `agr_crop_manager` (`manager_code`, `manager_name`, `job_type`, `email`, `contact_info`, `phone_number`, `remark`) VALUES
('M0000001', '张三', '田间管理', 'zhangsan@example.com', '1234567890', '13800138000', '负责水稻田的日常管理'),
('M0000002', '李四', '病虫害防治', 'lisi@example.com', '2345678901', '13900139000', '负责病虫害监测和防治工作'),
('M0000003', '王五', '灌溉管理', 'wangwu@example.com', '3456789012', '13700137000', '负责农田灌溉系统的维护和管理'),
('M0000004', '赵六', '施肥管理', 'zhaoliu@example.com', '4567890123', '13600136000', '负责农田施肥计划的制定和执行'),
('M0000005', '孙七', '机械操作', 'sunqi@example.com', '5678901234', '13500135000', '负责农业机械的操作和维护'),
('M0000006', '周八', '种子管理', 'zhouba@example.com', '6789012345', '13400134000', '负责种子的采购和管理'),
('M0000007', '吴九', '数据记录', 'wujiu@example.com', '7890123456', '13300133000', '负责农田数据的记录和分析'),
('M0000008', '郑十', '质量检测', 'zhengshi@example.com', '8901234567', '13200132000', '负责农产品的质量检测和评估');


-- 删除已存在的表
DROP TABLE IF EXISTS `agr_equipment_management`;

-- 创建设备管理表
CREATE TABLE `agr_equipment_management` (
  `id` INT AUTO_INCREMENT PRIMARY KEY COMMENT '自增主键',
  `equipment_code` VARCHAR(8) DEFAULT NULL COMMENT '设备编号',
  `equipment_name` VARCHAR(255) DEFAULT NULL COMMENT '设备名称',
  `equipment_model` VARCHAR(255) DEFAULT NULL COMMENT '设备型号',
  `equipment_purpose` VARCHAR(255) DEFAULT NULL COMMENT '设备用途',
  `equipment_price` DECIMAL(10, 2) DEFAULT NULL COMMENT '设备价格',
  `equipment_company` VARCHAR(255) DEFAULT NULL COMMENT '设备生产公司',
  `equipment_status` VARCHAR(255) DEFAULT NULL COMMENT '设备当前状态',
  `remark` TEXT DEFAULT NULL COMMENT '备注',
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间（默认当前时间）',
  `created_by` VARCHAR(255) DEFAULT 'system' COMMENT '创建人（默认system）',
  `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间（默认当前时间）',
  `updated_by` VARCHAR(255) DEFAULT 'system' COMMENT '更新人（默认system）'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='设备管理表';

-- 插入测试数据
INSERT INTO `agr_equipment_management` (`equipment_code`, `equipment_name`, `equipment_model`, `equipment_purpose`, `equipment_price`, `equipment_company`, `equipment_status`, `remark`) VALUES
('E0000001', '光传感器', 'GS-100', '监测光照强度', 250.00, '华测科技', '正常', '用于农田光照监测'),
('E0000002', '温度传感器', 'TS-200', '监测环境温度', 180.00, '华测科技', '正常', '用于农田温度监测'),
('E0000003', '湿度传感器', 'HS-300', '监测土壤湿度', 200.00, '华测科技', '正常', '用于农田湿度监测'),
('E0000004', '薄膜', 'FL-400', '覆盖农田，保温保湿', 50.00, '农友塑料', '正常', '用于春季保温保湿'),
('E0000005', '钢管', 'GB-500', '搭建温室骨架', 150.00, '钢铁集团', '正常', '用于温室建设'),
('E0000006', '水管', 'WS-600', '灌溉系统管道', 100.00, '水务公司', '正常', '用于农田灌溉');

-- 删除已存在的表
DROP TABLE IF EXISTS `agr_equipment_group`;

-- 创建设备组管理表
CREATE TABLE `agr_equipment_group` (
  `id` INT AUTO_INCREMENT PRIMARY KEY COMMENT '自增主键',
  `group_code` VARCHAR(8) DEFAULT NULL COMMENT '设备组编号',
  `group_name` VARCHAR(255) DEFAULT NULL COMMENT '设备组名称',
  `equipment_code` VARCHAR(8) DEFAULT NULL COMMENT '设备编号',
  `remark` TEXT DEFAULT NULL COMMENT '备注'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='设备组管理表';

-- 插入测试数据
INSERT INTO `agr_equipment_group` (`group_code`, `equipment_code`, `remark`) VALUES
('G0000001', 'E0000001', '包含光传感器'),
('G0000001', 'E0000002', '包含温度传感器'),
('G0000001', 'E0000003', '包含湿度传感器'),
('G0000001', 'E0000006', '包含灌溉用的水管'),
('G0000002', 'E0000005', '包含用于温室建设的钢管'),
('G0000002', 'E0000004', '包含用于保温保湿的薄膜');

-- 删除已存在的表
DROP TABLE IF EXISTS `agr_planting`;

-- 创建种植表
CREATE TABLE `agr_planting` (
  `id` INT AUTO_INCREMENT PRIMARY KEY COMMENT '自增主键',
  `planting_code` VARCHAR(8) DEFAULT NULL COMMENT '种植编号',
  `variety_code` VARCHAR(8) DEFAULT NULL COMMENT '品种编号',
  `variety_name` VARCHAR(255) DEFAULT NULL COMMENT '品种名称',
  `plot_code` VARCHAR(8) DEFAULT NULL COMMENT '地块编号',
  `plot_name` VARCHAR(255) DEFAULT NULL COMMENT '地块名',
  `plot_area` DECIMAL(10, 2) DEFAULT NULL COMMENT '地块面积m2',
  `group_code` VARCHAR(8) DEFAULT NULL COMMENT '设备组编号',
  `manager_code` VARCHAR(8) DEFAULT NULL COMMENT '管理员编号',
  `current_status` VARCHAR(255) DEFAULT NULL COMMENT '当前状态',
  `production_amount` INT DEFAULT 0 COMMENT '产量kg',
  `remark` TEXT DEFAULT NULL COMMENT '备注',
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间（默认当前时间）',
  `created_by` VARCHAR(255) DEFAULT 'system' COMMENT '创建人（默认system）',
  `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间（默认当前时间）',
  `updated_by` VARCHAR(255) DEFAULT 'system' COMMENT '更新人（默认system）'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='种植表';

-- 插入测试数据
INSERT INTO `agr_planting` (`planting_code`, `variety_code`, `variety_name`, `plot_code`, `plot_name`, `plot_area`, `group_code`, `manager_code`, `current_status`, `remark`) VALUES
('P0000001', 'V0000001', '水稻A', 'PL000001', '北京a区地块a1', 10.5, 'G0000001', 'M0000001', '播种', '正在播种阶段'),
('P0000002', 'V0000002', '小麦B', 'PL000002', '北京b区地块b2', 8.0, 'G0000002', 'M0000002', '生长', '生长良好'),
('P0000003', 'V0000003', '玉米C', 'PL000003', '上海c区地块c1', 12.0, 'G0000003', 'M0000003', '收获', '即将收获'),
('P0000004', 'V0000004', '大豆D', 'PL000004', '豆田1', 7.5, 'G0000004', 'M0000004', '播种', '准备播种'),
('P0000005', 'V0000005', '早春红玉E', 'PL000005', '北京x区地块x1', 9.0, 'G0000005', 'M0000005', '生长', '生长情况良好'),
('P0000006', 'V0000006', '蔬菜F', 'PL000006', '菜地1', 6.0, 'G0000006', 'M0000006', '收获', '即将收获');



DROP TABLE IF EXISTS agr_temperature_collection;

CREATE TABLE agr_temperature_collection (
    id INT AUTO_INCREMENT PRIMARY KEY COMMENT '自增主键',
    planting_id VARCHAR(50) COMMENT '种植编号',
    collection_id DATE COMMENT '采集编号（日期）',
    temperature FLOAT COMMENT '温度',
    collection_time TIME COMMENT '采集时间',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='温度采集信息表';

-- 种植编号 P001 的数据
INSERT INTO agr_temperature_collection (planting_id, collection_id, temperature, collection_time)
VALUES
('P0000001', '2023-10-01', 10.5, '00:00:00'),
('P0000001', '2023-10-01', 22.3, '00:15:00'),
('P0000001', '2023-10-01', 38.1, '00:30:00'),
('P0000001', '2023-10-01', 27.9, '00:45:00'),
('P0000001', '2023-10-01', 26.7, '01:00:00');






