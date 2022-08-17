package fa.trainning.excel;

import java.io.ByteArrayInputStream;
import java.util.List;

import fa.trainning.entity.OrderDetail;

public interface ExcelFileService {
	ByteArrayInputStream export(List<OrderDetail> orderDetails);
}
