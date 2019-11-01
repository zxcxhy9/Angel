CREATE TABLE `car` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  UNIQUE KEY `car_id_idx` (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8