package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    /**
     * 상품 저장
     */
    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    /**
     * 상품 수정 (변경감지)
     */
    @Transactional
    public Item updateItem(Long itemId, String name, int price, int stockQuantity) {

        Item findItem = itemRepository.findOne(itemId);
        findItem.change(itemId, name, price, stockQuantity);
        /** 따로 persist, merge 하지 않아도 JPA 가 영속성 엔티티의 변경감지를 하여 처리해줌*/
        return findItem;
    }

    /**
     * 상품 전체 조회
     */
    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    /**
     * 상품 단일 조회
     */
    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }

}//class

