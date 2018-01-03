package com.gomefinance.hl.security.common;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 集成基础的mapper
 *
 * @Author hzj
 * @Date 2017/6/14 14:31
 * @Description :
 */
public interface BaseMapper<T> extends MySqlMapper<T> , Mapper<T> {
}
