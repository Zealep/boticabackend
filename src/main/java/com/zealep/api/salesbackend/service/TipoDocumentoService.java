package com.zealep.api.salesbackend.service;


import com.zealep.api.salesbackend.model.entity.TipoDocumento;

import java.util.List;

public interface TipoDocumentoService {

    TipoDocumento findById(Long id);

    List<TipoDocumento> findAll();

    TipoDocumento save(TipoDocumento t);

    void delete(Long id);

    boolean isExist(Long id);


}
