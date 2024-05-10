package Repository

import com.example.outputcsv.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OutputRepository: JpaRepository<Product, Long> {
}