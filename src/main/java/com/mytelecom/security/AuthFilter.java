/*
 * package com.mytelecom.security;
 * 
 * import com.mytelecom.repository.UserRepository; import
 * com.mytelecom.repository.entity.MyTelecomUser; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.core.Ordered; import
 * org.springframework.core.annotation.Order; import
 * org.springframework.stereotype.Component; import
 * org.springframework.web.filter.GenericFilterBean;
 * 
 * import javax.servlet.FilterChain; import javax.servlet.ServletException;
 * import javax.servlet.ServletRequest; import javax.servlet.ServletResponse;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse; import java.io.IOException; import
 * java.nio.charset.StandardCharsets; import java.util.Base64; import
 * java.util.Optional;
 * 
 * @Component
 * 
 * @Order(Ordered.HIGHEST_PRECEDENCE) public class AuthFilter extends
 * GenericFilterBean {
 * 
 * @Autowired private UserRepository repository;
 * 
 * @Override public void doFilter(ServletRequest servletRequest, ServletResponse
 * servletResponse, FilterChain filterChain) throws IOException,
 * ServletException { HttpServletRequest request = (HttpServletRequest)
 * servletRequest; HttpServletResponse response = (HttpServletResponse)
 * servletResponse;
 * request.getHeaderNames().asIterator().forEachRemaining(System.out::println);
 * if (request.getRequestURI() != null &&
 * !request.getRequestURI().contains("/user-registration")) { final String
 * authorization = request.getHeader("Authorization"); if (authorization ==
 * null) { throw new RuntimeException("User not authorized!"); } if
 * (authorization != null && authorization.toLowerCase().startsWith("basic")) {
 * // Authorization: Basic base64credentials String base64Credentials =
 * authorization.substring("Basic".length()).trim(); byte[] credDecoded =
 * Base64.getDecoder().decode(base64Credentials); String credentials = new
 * String(credDecoded, StandardCharsets.UTF_8); // credentials =
 * username:password final String[] values = credentials.split(":", 2);
 * Optional<MyTelecomUser> optionalUser = repository.findById(values[0]);
 * if(optionalUser.isEmpty()) throw new RuntimeException("User not registered");
 * if(!optionalUser.get().getPassword().equals(values[1])){ throw new
 * RuntimeException("UserId/Password is wrong"); } } }
 * filterChain.doFilter(request, response); } }
 */