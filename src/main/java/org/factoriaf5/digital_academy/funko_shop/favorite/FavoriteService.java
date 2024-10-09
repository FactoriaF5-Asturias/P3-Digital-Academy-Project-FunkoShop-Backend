package org.factoriaf5.digital_academy.funko_shop.favorite;

import org.factoriaf5.digital_academy.funko_shop.category.Category;
import org.factoriaf5.digital_academy.funko_shop.category.CategoryDTO;
import org.factoriaf5.digital_academy.funko_shop.product.Product;
import org.factoriaf5.digital_academy.funko_shop.product.ProductDTO;
import org.factoriaf5.digital_academy.funko_shop.product.ProductRepository;
import org.factoriaf5.digital_academy.funko_shop.user.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<FavoriteDTO> addProductToFavorite(Long userId, Long productId) {
        Product product = productRepository.findById(productId).orElseThrow();

        Favorite favorite = new Favorite();
        favorite.setUser(new User(userId, null, null, null, null, null, null, null, null, null));
        favorite.setProduct(product);

        favoriteRepository.save(favorite);

        return favoriteRepository.findByUserId(userId)
                .stream()
                .map(this::convertToFavoriteDTO)
                .collect(Collectors.toList());
    }

    private ProductDTO convertToProductDTO(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getName(),
                Optional.ofNullable(product.getImageHash()),
                product.getDescription(),
                product.getPrice(),
                calculateDiscountedPrice(product.getPrice(), product.getDiscount()),
                product.getStock(),
                product.getCreatedAt(),
                convertToCategoryDTO(product.getCategory()),
                product.getDiscount());
    }

    private float calculateDiscountedPrice(float price, int discount) {
        if (discount > 0) {
            return price - (price * discount / 100);
        }
        return price;
    }

    private CategoryDTO convertToCategoryDTO(Category category) {
        return new CategoryDTO(
                category.getId(),
                category.getName(),
                category.getImageHash(),
                category.isHighlights());
    }

    private FavoriteDTO convertToFavoriteDTO(Favorite favorite) {
        return new FavoriteDTO(favorite.getId(), convertToProductDTO(favorite.getProduct()),
                favorite.getUser().getId());
    }

    public void removeProductFromFavorite(Long userId, Long productId) {
        List<Favorite> favorites = favoriteRepository.findByUserId(userId);

        Favorite favoriteToRemove = favorites.stream()
                .filter(fav -> fav.getProduct().getId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Favorite not found for productId: " + productId));

        favoriteRepository.deleteById(favoriteToRemove.getId());
    }

    public Page<FavoriteDTO> getFavoriteByUserId(Long userId, Pageable pageable) {
        return favoriteRepository.findByUserId(userId, pageable)
                .map(this::convertToFavoriteDTO);
    }

    public Boolean checkFavorite(Long userId, Long productId) {
        Optional<Favorite> favorite = favoriteRepository.findByUserIdAndProductId(userId, productId);
        return favorite.isPresent();  
    }
}
