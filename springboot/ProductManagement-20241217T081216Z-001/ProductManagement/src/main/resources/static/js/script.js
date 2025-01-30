
  // Filter products by name
  function filterProducts() {
      const query = document.getElementById('searchBar').value.toLowerCase();
      const cards = document.querySelectorAll('.product-card');

      cards.forEach(card => {
          const name = card.getAttribute('data-name').toLowerCase();
          card.style.display = name.includes(query) ? 'block' : 'none';
      });
  }

// Fetch product data and show the modal
function openModal(productId) {
    fetch(`/product/${productId}`)
        .then(response => {
            if (!response.ok) {
                throw new Error("Failed to fetch product details.");
            }
            return response.json();
        })
        .then(product => {
            // Populate form fields
            document.getElementById('edit-name').value = product.name;
            document.getElementById('edit-price').value = product.price;

            // Set form action dynamically
            const editForm = document.getElementById('editProductForm');
            editForm.setAttribute('action', `/product/edit/${product.id}`);

            // Display the modal
            document.getElementById('editProductModal').style.display = 'block';
        })
        .catch(error => console.error('Error fetching product:', error));
}

// Close modal
function closeModal() {
    document.getElementById('editProductModal').style.display = 'none';
}

// Close modal when clicking outside of it
window.onclick = function(event) {
    const modal = document.getElementById('editProductModal');
    if (event.target === modal) {
        closeModal();
    }
};


  // Close modal
  function closeModal() {
      document.getElementById('editProductModal').style.display = 'none';
  }

  // Close modal when clicking outside
  window.onclick = function(event) {
      const modal = document.getElementById('editProductModal');
      if (event.target === modal) {
          closeModal();
      }
  }
