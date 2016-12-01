create index IX_D8819E2 on LR_PRODUCT_SB_Product (groupId, status);
create index IX_4149DBE2 on LR_PRODUCT_SB_Product (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_9FBF2E4 on LR_PRODUCT_SB_Product (uuid_[$COLUMN_LENGTH:75$], groupId);