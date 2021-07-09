package com.linkpal.service.impl;

import com.linkpal.domain.entity.Weblog;
import com.linkpal.mapper.WeblogMapper;
import com.linkpal.service.WeblogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 樊浩
 * @since 2021-07-05
 */
@Service
public class WeblogServiceImpl extends ServiceImpl<WeblogMapper, Weblog> implements WeblogService {

}
