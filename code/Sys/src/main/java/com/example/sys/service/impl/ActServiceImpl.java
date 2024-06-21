package com.example.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.sys.entity.Account;
import com.example.sys.mapper.ActMapper;
import com.example.sys.service.ActService;
import org.springframework.stereotype.Service;

@Service
public class ActServiceImpl extends ServiceImpl<ActMapper, Account> implements ActService {
}
