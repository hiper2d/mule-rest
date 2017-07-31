package com.hiper2d.service;

import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public abstract class BaseService {

}
