package com.zealep.api.salesbackend.service.impl;


import com.zealep.api.salesbackend.model.entity.TipoDocumento;
import com.zealep.api.salesbackend.repository.TipoDocumentoRepository;
import com.zealep.api.salesbackend.service.TipoDocumentoService;
import com.zealep.api.salesbackend.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("tipoDocumentoService")
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

    @Autowired
    TipoDocumentoRepository tipoDocumentoRepository;

    @Override
    @Transactional(readOnly = true)
    public TipoDocumento findById(Long id) {
        return tipoDocumentoRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TipoDocumento> findAll() {
        return tipoDocumentoRepository.findAllActives(Constants.ACTIVE_STATE);
    }


    @Override
    @Transactional
    public TipoDocumento save(TipoDocumento t) {
        t.setEstado(Constants.ACTIVE_STATE);
        return tipoDocumentoRepository.save(t);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        tipoDocumentoRepository.deleteLogic(id, Constants.INACTIVE_STATE);
    }

    @Override
    public boolean isExist(Long id) {
        return findById(id) != null;
    }
}
