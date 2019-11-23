package com.example.demo.paging;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class OffsetLimitPageable implements Pageable {

    private final int offset;
    private final int limit;

    public OffsetLimitPageable(int offset, int limit) {
        this.offset = offset;
        this.limit = limit;
    }

    @Override
    public int getPageNumber() {
        return 0;
    }

    @Override
    public int getPageSize() {
        return limit;
    }

    @Override
    public long getOffset() {
        return offset;
    }

    @Override
    public Pageable next() {
        return new OffsetLimitPageable(offset + limit, limit);
    }

    @Override
    public Pageable previousOrFirst() {
        return hasPrevious() ? new OffsetLimitPageable(offset - limit, limit) : first();
    }

    @Override
    public Pageable first() {
        return new OffsetLimitPageable(offset, limit);
    }

    @Override
    public boolean hasPrevious() {
        return offset == 0 || offset - limit < 0;
    }

    @Override
    public Sort getSort() {
        return Sort.unsorted();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();

        result = prime * result + offset;
        result = prime * result + limit;

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        OffsetLimitPageable other = (OffsetLimitPageable) obj;
        return this.offset == other.offset && this.limit == other.limit;
    }
}
