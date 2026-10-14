package com.ballastlane.pokedex.domain.shared;

import java.util.List;

/** One page of results (stub). */
public record Page<T>(List<T> content, int page, int size, long totalElements) {

  public static <T> Page<T> of(List<T> content, PageRequest request, long totalElements) {
    return new Page<>(content, request.page(), request.size(), totalElements);
  }

  public int totalPages() {
    return 0;
  }
}
