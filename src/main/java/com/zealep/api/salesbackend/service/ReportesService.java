package com.zealep.api.salesbackend.service;

import com.zealep.api.salesbackend.model.dto.*;

import java.io.ByteArrayInputStream;
import java.util.List;

public interface ReportesService {

    ByteArrayInputStream exportExcelVentas(List<ReporteVentasDTO> reporteVentasDTOList);
    ByteArrayInputStream exportExcelDetalleVentas(List<ReporteDetallesVentasDTO> reporteVentasDTOList);
    ByteArrayInputStream exportExcelCompras(List<ReporteComprasDTO> reporteComprasDTOList);
    ByteArrayInputStream exportExcelDetalleCompras(List<ReporteDetallesComprasDTO> reporteComprasDTOList);
    List<ReporteMesDTO> getVentasPorMes();
    List<ReporteMesDTO> getComprasPorMes();


}
