package com.ssh.quartz.service;

import com.ssh.quartz.mbg.model.PmsBrand;

import java.util.List;

/**
 * @description
 * @author: ssh
 * @Date: 2020/10/26 11:22
 */
public interface PmsBrandService {
    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand brand);

    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);
}
