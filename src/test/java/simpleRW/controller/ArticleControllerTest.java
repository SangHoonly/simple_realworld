package simpleRW.controller;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import simpleRW.dto.ArticleDto;
import simpleRW.service.ArticleService;

@SpringBootTest
@AutoConfigureMockMvc
public class ArticleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ArticleService articleService;

    List<ArticleDto> articleDtos = new ArrayList<>();
    Map<String, List<ArticleDto>> map = new HashMap<>();
    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void init() {
        articleDtos.clear();
        map.clear();

        articleDtos.add(ArticleDto.builder().id(1).title("1번 게시글").author("Lee Jerry").build());
        articleDtos.add(ArticleDto.builder().title("타이틀").build());

        map.put("articles", articleDtos);

        when(articleService.findAllArticle()).thenReturn(map);

    }


    @Test
    @DisplayName("GET /articles 요청 시 모든 게시글들의 리스트를 볼 수 있다.")
    public void get_articles_test() throws Exception {
        mockMvc
            .perform(get("/articles"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.articles.length()", is(2)))
            .andExpect(jsonPath("$.articles[0].author", is("Lee Jerry")));
    }

    @Test
    @DisplayName("GET /articles/{id} 요청 시 해당 id의 게시글을 볼 수 있다.")
    public void get_one_article_test() throws Exception {
        int id = 1;
        when(articleService.findOneArticle(1)).thenReturn(articleDtos.get(0));

        mockMvc
            .perform(get("/articles/" + Integer.toString(id)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id", is(1)))
            .andExpect(jsonPath("$.title", is("1번 게시글")));
    }


    @Test
    @DisplayName("POST /articles 요청 시 성공적으로 응답을 반환한다.")
    public void create_new_article_test() throws Exception {

        Map<String, Object> articleReq = new HashMap<>();
        articleReq.put("title", "106번 게시글");
        articleReq.put("author", "이백삼십삼상훈");


        mockMvc.perform(post("/articles")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(articleReq)))
                .andExpect(status().isOk());
    }
}