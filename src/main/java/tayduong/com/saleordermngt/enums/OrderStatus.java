package tayduong.com.saleordermngt.enums;

import lombok.Getter;

@Getter
public enum OrderStatus {
    NHAP("Nhap"),                      // Draft
    CHUYEN_KE_TOAN("Chuyen ke toan"),  // Sent to Accounting
    CHUYEN_THU_KHO("Chuyen thu khi"),  // Sent to Warehouse
    DANG_GIAO_HANG("Dang giao hang"),  // In Delivery
    HOAN_THANH("Hoan thanh"),
    ;          // Completed

    private final String status;

    OrderStatus(String status) {
        this.status = status;
    }

}
